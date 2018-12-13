package com.mic.xsample.activity.opensource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mic.xsample.R;
import com.mic.xsample.activity.view.ViewDrawFlowActivity;
import com.mic.xsample.activity.view.ViewPagerActivity;
import com.mic.xsample.fragment.view.LetterSideBarFragment;
import com.mic.xsample.fragment.view.LockPatternViewFragment;
import com.mic.xsample.fragment.view.ProgressBarFragment;
import com.mic.xsample.fragment.view.QQSlidingMenuFragment;
import com.mic.xsample.fragment.view.QQStepFragment;
import com.mic.xsample.fragment.view.RatingBarFragment;
import com.mic.xsample.fragment.view.ShapeFragment;
import com.mic.xsample.fragment.view.SlidingMenuFragment;
import com.mic.xsample.fragment.view.TagLayoutFragment;
import com.mic.xsample.fragment.view.TouchViewFragment;
import com.mic.xsample.fragment.view.TouchViewGroupFragment;
import com.mic.xsample.fragment.view.TrackTextViewFragment;
import com.mic.xsample.fragment.view.VerticalDragListViewFragment;
import com.mic.xsample.fragment.view.XTextViewFragment;

public class OpenSourceItemActivity extends AppCompatActivity {


    private FragmentTransaction transaction;

    private static final int GLIDE=0;
    private static final int HANDLE=1;
    private static final int FIXBUG=2;
    private static final int OKHTTP=3;
    private static final int RETROFIT=4;
    private static final int RXBINDING=5;
    private static final int RXBITMAP=6;
    private static final int RXPERMISSIONS=7;
    private static final int RX_RETROFIT=8;
    private static final int UPDATE_UI =9;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        Intent intent =getIntent();
        int id = intent.getIntExtra("position",0);
        String name = intent.getStringExtra("name");

        FragmentManager fragmentManager = getSupportFragmentManager();
        transaction=fragmentManager.beginTransaction();
        showItemView(id);
    }

    private void showItemView(int id){
        switch (id){
            case GLIDE:
                startActivity(GlideActivity.class);
                break;
            case HANDLE:
               startActivity(HandleActivity.class);
                break;
            case FIXBUG:
                startActivity(MainActivity.class);
                break;
            case OKHTTP:
                startActivity(OkhttpActivity.class);
                break;
            case RETROFIT:
                startActivity(RetrofitActivity.class);
                break;
            case RXBINDING:
                startActivity(RxBitmapActivity.class);
                break;
            case RXBITMAP:
                startActivity(RxBindingActivity.class);
                break;
            case RXPERMISSIONS:
                startActivity(RxPermissionsActivity.class);
                break;
            case RX_RETROFIT:
                startActivity(RxRetrofitActivity.class);
                break;
            case UPDATE_UI:
                startActivity(UpdateUIActivity.class);
                break;

        }
    }


    private void replaceFragment(Fragment fragment){
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    private void startActivity(Class clazz){
        Intent intent = new Intent(OpenSourceItemActivity.this,clazz);
        startActivity(intent);
    }


}
