package com.mic.joke.activity;


import com.mic.joke.FragmentManagerHelper;
import com.mic.joke.R;
import com.mic.joke.fragment.FindFragment;
import com.mic.joke.fragment.HomeFragment;
import com.mic.joke.fragment.MessageFragment;
import com.mic.joke.fragment.NewFragment;
import com.mic.libbusiness.BaseSkinActivity;
import com.mic.libbusiness.DefaultNavigationBar;

import butterknife.OnClick;

public class HomeActivity extends BaseSkinActivity {

    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private NewFragment mNewFragment;
    private MessageFragment mMessageFragment;

    private FragmentManagerHelper mFragmentHelper;

    @Override
    protected void initTitle() {
        DefaultNavigationBar navigationBar = new
                DefaultNavigationBar.Builder(this)
                .setTitle("首页")
                .hideLeftIcon()
                .builder();
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_home);
    }


    @Override
    protected void initData() {
        mFragmentHelper = new FragmentManagerHelper(getSupportFragmentManager(), R.id.main_tab_fl);
        mHomeFragment = new HomeFragment();
        mFragmentHelper.add(mHomeFragment);
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.home_rb)
    public void homeRbClick() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        mFragmentHelper.switchFragment(mHomeFragment);
    }

    @OnClick(R.id.find_rb)
    public void findRbClick() {
        if (mFindFragment == null) {
            mFindFragment = new FindFragment();
        }
        mFragmentHelper.switchFragment(mFindFragment);
    }

    @OnClick(R.id.new_rb)
    public void newRbClick() {
        if (mNewFragment == null) {
            mNewFragment = new NewFragment();
        }
        mFragmentHelper.switchFragment(mNewFragment);
    }

    @OnClick(R.id.message_rb)
    public void messageRbClick() {
        if (mMessageFragment == null) {
            mMessageFragment = new MessageFragment();
        }
        mFragmentHelper.switchFragment(mMessageFragment);
    }
}
