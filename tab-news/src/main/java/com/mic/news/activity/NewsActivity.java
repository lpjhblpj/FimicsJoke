package com.mic.news.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jakewharton.rxbinding2.widget.RxAbsListView;
import com.mic.news.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
}
