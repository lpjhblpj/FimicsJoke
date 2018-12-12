package com.mic.joke.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mic.joke.R;
import com.mic.joke.view.Bottom;
import com.mic.joke.view.BottomLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomLayout bottomLayout;
    private ArrayList<Bottom> bottomList = new ArrayList<Bottom>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        bottomLayout.setBottomList(bottomList);
        bottomLayout.setmOnTabChanged(new BottomLayout.OnTabChanged() {
            @Override
            public void onSelected(int index) {

            }
        });
    }

    private void initData() {
        bottomList.add(new Bottom("首页",R.drawable.tab_home));
        bottomList.add(new Bottom("新闻",R.drawable.tab_news));
        bottomList.add(new Bottom("视频",R.drawable.tab_video));
        bottomList.add(new Bottom("消息",R.drawable.tab_msg));
        bottomList.add(new Bottom("用户",R.drawable.tab_user));
    }


    private void initView(){
      bottomLayout=this.findViewById(R.id.bottom_layoty);
    }


}
