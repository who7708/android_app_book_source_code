# FileProvider
在给app做版本升级的时候，先从服务器下载新版本的apk文件到sdcard路径，然后调用安装apk的代码，一般写法如下：
```
private void openAPK(String fileSavePath){
    File file=new File(fileSavePath);
    Intent intent = new Intent(Intent.ACTION_VIEW);
    Uri data = Uri.fromFile(file);
    intent.setDataAndType(data, "application/vnd.android.package-archive");
    startActivity(intent);
}
```
这样的写法在Android7.0版本之前是没有任何问题，只要给一个apk文件路径就能打开安装。但是在Android7.0版本上会报错:
```
 android.os.FileUriExposedException:
 file:///storage/emulated/0/Download/FileProvider.apk 
 exposed beyond app through Intent.getData()
```

从Android 7.0开始，一个应用提供自身文件给其它应用使用时，如果给出一个file://格式的URI的话，应用会抛出FileUriExposedException。这是由于谷歌认为目标app可能不具有文件权限，会造成潜在的问题。所以让这一行为快速失败。
