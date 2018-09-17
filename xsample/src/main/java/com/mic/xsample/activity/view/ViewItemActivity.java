package com.mic.xsample.activity.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.mic.xsample.R;
import com.mic.xsample.fragment.ProgressBarFragment;
import com.mic.xsample.fragment.QQStepFragment;
import com.mic.xsample.fragment.ShapeFragment;
import com.mic.xsample.fragment.TrackTextViewFragment;
import com.mic.xsample.fragment.XTextViewFragment;

public class ViewItemActivity extends AppCompatActivity {




    private static final int X_TEXTVIEW=0;
    private static final int QQ_STEP=1;
    private static final int TRACK_TEXTVIEW=2;
    private static final int PROGRESS_BAR=3;
    private static final int VIEW_PAGER=4;
    private static final int SHAPE_VIEW=5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        Intent intent =getIntent();
        int id = intent.getIntExtra("position",0);
        String name = intent.getStringExtra("name");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        showItemView(id,transaction);
    }

    private void showItemView(int id,FragmentTransaction transaction){
        switch (id){


            case  X_TEXTVIEW:
                XTextViewFragment xTextViewFragment = new XTextViewFragment();
                transaction.replace(R.id.container,xTextViewFragment);
                transaction.commit();
                break;
            case  QQ_STEP:
                QQStepFragment qqStepFragment = new QQStepFragment();
                transaction.replace(R.id.container,qqStepFragment);
                transaction.commit();
                break;
            case TRACK_TEXTVIEW:
                TrackTextViewFragment trackTextViewFragment = new TrackTextViewFragment();
                transaction.replace(R.id.container,trackTextViewFragment);
                transaction.commit();
                break;
            case PROGRESS_BAR:
                ProgressBarFragment progressBarFragment = new ProgressBarFragment();
                transaction.replace(R.id.container,progressBarFragment);
                transaction.commit();
                break;
            case VIEW_PAGER:
                finish();
                Intent intent = new Intent(ViewItemActivity.this,ViewPagerActivity.class);
                startActivity(intent);
                break;
            case SHAPE_VIEW:
                ShapeFragment shapeFragment=new ShapeFragment();
                transaction.replace(R.id.container,shapeFragment);
                transaction.commit();
                break;
        }
    }


}
