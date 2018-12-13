package com.mic.xsample.okhttp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;


import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // rxPermission
//        RxPermissions rxPermissions = new RxPermissions(this);
//
//        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.READ_EXTERNAL_STORAGE)
//                .subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        if(aBoolean){
//                            // 权限申请，并且用户给了权限
//                            uploadFile();
//                        }
//                    }
//                });
    }

    private void uploadFile() {
        // 这个是 Okhttp 上传文件的用法
        String url = "https://api.saiwuquan.com/api/upload";
        File file = new File(Environment.getExternalStorageDirectory(), "test.apk");
        OkHttpClient httpClient = new OkHttpClient();
        // 构建请求 Body , 这个我们之前自己动手写过
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        builder.addFormDataPart("platform", "android");
        builder.addFormDataPart("file", file.getName(),
                RequestBody.create(MediaType.parse(guessMimeType(file.getAbsolutePath())), file));

        ExMultipartBody exMultipartBody = new ExMultipartBody(builder.build()
                ,new UploadProgressListener(){

            @Override
            public void onProgress(long total, long current) {
                showToast(total,current);
            }
        });

        // 怎么监听上传文件的进度？

        // 构建一个请求
        final Request request = new Request.Builder()
                .url(url)
                .post(exMultipartBody).build();
        // new RealCall 发起请求
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", response.body().string());
            }
        });
    }

    private void showToast(final long total, final long current) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(MainActivity.this,current+"/"+total,Toast.LENGTH_LONG).show();
            }
        });
    }

    private String guessMimeType(String filePath) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();

        String mimType = fileNameMap.getContentTypeFor(filePath);

        if(TextUtils.isEmpty(mimType)){
            return "application/octet-stream";
        }
        return mimType;
    }
}
