package com.ansen.baidumaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.model.LatLng;

public class MainActivity extends AppCompatActivity {
    private  MapView mapView;
    private BaiduMap baiduMap;//定义地图对象的操作方法与接口
    private boolean isFirstLoc = true;//是否首次定位

    private LocationClient locationClient = null;//定位控制类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        //在真实开发中，这句代码放到自定的Application中比较合适
        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        mapView= (MapView) findViewById(R.id.mapview);
        baiduMap = mapView.getMap();

        baiduMap.setMyLocationEnabled(true);//开启定位图层

        //用户自定义定位图标
        BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory.fromResource(R.mipmap.icon_geo);

        //参数1: 有三个值 LocationMode.COMPASS 罗盘态，显示定位方向圈，保持定位图标在地图中心
        //              LocationMode.FOLLOWING 跟随态，保持定位图标在地图中心
        //              LocationMode.NORMAL  普通态： 更新定位数据时不对地图做任何操作
        //参数2:是否允许显示方向信息
        //参数3:用户自定义定位图标
        MyLocationConfiguration config = new MyLocationConfiguration(LocationMode.NORMAL,true,mCurrentMarker);
        baiduMap.setMyLocationConfiguration(config);//设置定位图层显示方式

        startRequestLocation();//开启定位
    }

    private void startRequestLocation() {
        LocationClientOption mOption = new LocationClientOption();
        mOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        mOption.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        mOption.setScanSpan(3000);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        locationClient = new LocationClient(this);
        locationClient.setLocOption(mOption);//设置定位参数
        locationClient.registerLocationListener(locationListener);//注册监听

        locationClient.start();//开启定位 目前只支持在主线程中启动
    }

    private BDLocationListener locationListener=new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (null != location && location.getLocType() != BDLocation.TypeServerError){
                Log.i("ansen","getLongitude:"+location.getLongitude());

                MyLocationData locData = new MyLocationData.Builder()
                        .accuracy(location.getRadius())//设置定位数据的精度信息
                        .latitude(location.getLatitude())//纬度
                        .longitude(location.getLongitude())//经度
                        .build();

                //设置定位数据, 只有先允许定位图层后设置数据才会生效
                baiduMap.setMyLocationData(locData);

                if (isFirstLoc) {//第一次定位
                    isFirstLoc = false;
                    LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());
                    MapStatus.Builder builder = new MapStatus.Builder();
                    builder.target(ll).zoom(18.0f);//设置地图缩放级别
                    //以动画方式更新地图状态，动画耗时 300 ms
                    baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                }
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mapView.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        locationClient.stop();//停止定位
        baiduMap.setMyLocationEnabled(false);//关闭定位图层
        //在activity执行onDestroy时执行mapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
        mapView=null;
    }
}
