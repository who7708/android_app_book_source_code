package com.ansen.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private LocationManager locationManager;
    private TextView tvLocation;
    private TextView tvAddress;

    //位置权限需要临时获取
    private String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
    private final int PERMS_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation= (TextView) findViewById(R.id.tv_location);
        tvAddress= (TextView) findViewById(R.id.tv_address);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        //Android 6.0以上版本需要临时获取权限
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1&&
                PackageManager.PERMISSION_GRANTED!=checkSelfPermission(perms[0])) {
            requestPermissions(perms,PERMS_REQUEST_CODE);
        }else{
            startRequestLocation();
        }
    }

    private void startRequestLocation(){
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(!gps){
            Toast.makeText(this,"请先设置界面开启GPS定位服务",Toast.LENGTH_LONG).show();
            return ;
        }

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);//通过GPS获取位置
        if (location != null) {
            showLocation(location);
        }

        /**
         * 开启定位监听变化
         * 参数1，定位方式：主要有GPS_PROVIDER和NETWORK_PROVIDER，前者是GPS,后者是GPRS以及WIFI定位
         * 参数2，位置信息更新周期.单位是毫秒
         * 参数3，位置变化最小距离：当位置距离变化超过此值时，将更新位置信息
         * 参数4，监听
         * 备注：参数2和3，如果参数3不为0，则以参数3为准；参数3为0，则通过时间来定时更新；两者为0，则随时刷新
         */
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10,locationListener);
    }

    private LocationListener locationListener=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }

        //当位置提供者的状态发生改变
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}

        //位置信息提供者可用时自动调用 例如gps开启
        @Override
        public void onProviderEnabled(String provider) {
        }
        //位置信息不可用时自动调用 例如禁用gps
        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    /**
     * 显示定位结果
     * @param location
     */
    private void showLocation(Location location){
        if(location!=null){
            tvLocation.setText("经度："+location.getLongitude()+"\n"+"纬度："+location.getLatitude());
        }
        Geocoder geocoder = new Geocoder(this,Locale.CHINA);
        try {
            //参数1:纬度 参数2:经度 参数3:返回地址的数目（由于同一经纬度可能对于多个地址，该参数取1-5之间）
            List<Address> addressList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            for (Address address : addressList) {
                tvAddress.setText(address.getCountryName()+" "+address.getLocality());
                Log.i("ansen", address.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
        switch(permsRequestCode){
            case PERMS_REQUEST_CODE:
                boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if(storageAccepted){
                    startRequestLocation();
                }
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationManager.removeUpdates(locationListener);
    }
}
