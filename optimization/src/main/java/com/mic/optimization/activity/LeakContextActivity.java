package com.mic.optimization.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mic.optimization.R;
import com.mic.optimization.common.CommUtil;
import com.mic.optimization.common.ListenerCollector;
import com.mic.optimization.view.LeakView;

public class LeakContextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_leak_context);
        //CommUtil commUtil = CommUtil.getInstance(getApplicationContext());
        //CommUtil commUtil = CommUtil.getInstance(this);

        LeakView  leakView = new LeakView(this);
        setContentView(leakView);

    }

    @Override
    protected void onStop() {
        super.onStop();
        ListenerCollector.clearListener();
    }
}
