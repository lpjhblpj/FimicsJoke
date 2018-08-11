package com.mic.xsample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mic.libbusiness.http.HttpCallBack;
import com.mic.libbusiness.model.DiscoverListResult;
import com.mic.libcore.http.HttpUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class HttpTest {


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void httpTest(){
        Context context = InstrumentationRegistry.getTargetContext();
        // 路径和参数是不能让别人反编译的，NDK -> .so  1.列表保存第一次，2.有些是保存最后所有
        HttpUtils.with(context).url("http://is.snssdk.com/2/essay/discovery/v3/")
                .cache(true)// 读取缓存
                .addParam("iid","6152551759").addParam("aid","7").execute(
                new HttpCallBack<DiscoverListResult>() {
                    @Override
                    public void onError(Exception e) {

                    }

                    @Override
                    public void onSuccess(DiscoverListResult result) {
                        // 成功回掉这个方法
                        //　目前是没有缓存，现在有了数据库，还有了网络引擎
                        // 思路  某些接口如果需要缓存请自己带标示
                    }
                });
    }
}
