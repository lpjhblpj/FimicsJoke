package com.mic.optimization.activity;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.mic.optimization.R;
import com.mic.optimization.fragment.LeakSingleFragment;


public class ViewItemActivity extends AppCompatActivity {


    private FragmentTransaction transaction;

    private static final int LEAK_SINGLETON=0;





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
            case LEAK_SINGLETON:
                startActivity(LeakContextActivity.class);
                break;

        }
    }


    private void replaceFragment(Fragment fragment){
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    private void startActivity(Class clazz){
        finish();
        Intent intent = new Intent(ViewItemActivity.this,clazz);
        startActivity(intent);
    }


}
