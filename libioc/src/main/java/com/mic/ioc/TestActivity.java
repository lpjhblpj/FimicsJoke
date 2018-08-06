package com.mic.ioc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class TestActivity extends AppCompatActivity {

    @ViewById (R.id.tv_test)
    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ViewUtils.inject(this);

        mTvTest.setText("ioc");
        mTvTest.setText("ddd99d000d");

        for (int i=0;i<200;i++){
            System.out.print(i);
        }
    }


    @OnClick(R.id.tv_test)
    private void onClick(){
        Toast.makeText(this,"onclick",Toast.LENGTH_LONG).show();
    }
}
