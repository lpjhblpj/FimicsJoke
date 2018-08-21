package com.mic.joke.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.mic.joke.R;
import com.mic.joke.adapter.DiscoverListAdapter;
import com.mic.joke.model.DiscoverListResult;
import com.mic.libbusiness.http.HttpCallBack;
import com.mic.libcore.fragment.BaseFragment;
import com.mic.libcore.http.HttpUtils;
import com.mic.libcore.ioc.ViewById;
import com.mic.xwidget.banner.BannerAdapter;
import com.mic.xwidget.banner.BannerView;
import com.mic.xwidget.banner.BannerViewPager;
import com.mic.xwidget.recyclerview.view.WrapRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/3.
 */
public class FindFragment extends BaseFragment implements BannerViewPager.BannerItemClickListener {

    private static final String TAG = "MainActivity";

    @ViewById(R.id.recycler_view)
    private WrapRecyclerView mRecyclerView;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        HttpUtils.with(context).url("http://is.snssdk.com/2/essay/discovery/v3/?")
                .addParam("iid", 6152551759L)
                .addParam("aid", 7)
                .cache(true)
                .execute(new HttpCallBack<DiscoverListResult>() {
                    @Override
                    public void onError(Exception e) {

                    }

                    @Override
                    public void onSuccess(DiscoverListResult result) {

                        // 先显示列表
                        showListData(result.getData().getCategories().getCategory_list());
                        addBannerView(result.getData().getRotate_banner().getBanners());
                    }
                });
    }

    /**
     * 初始化Banner
     * @param banners
     */
    private void addBannerView(final List<DiscoverListResult.DataBean.RotateBannerBean.BannersBean> banners) {
        Log.e("TAG", "banners --> " + banners.size());

        // 后台没有轮播那就不添加
        if(banners.size()<=0){
            return;
        }

        BannerView bannerView = (BannerView) LayoutInflater.from(context)
                .inflate(R.layout.layout_banner_view, mRecyclerView, false);

        // 自己把万能的无限轮播看一下
        bannerView.setAdapter(new BannerAdapter() {
            @Override
            public View getView(int position, View convertView) {
                if (convertView == null) {
                    convertView = new ImageView(context);
                }
                ((ImageView) convertView).setScaleType(ImageView.ScaleType.CENTER_CROP);

                Glide.with(context).load(banners.get(position).getBanner_url().getUrl_list()
                        .get(0).getUrl()).into((ImageView) convertView);
                return convertView;
            }

            @Override
            public int getCount() {
                return banners.size();
            }

            @Override
            public String getBannerDesc(int position) {
                return banners.get(position).getBanner_url().getTitle();
            }
        });

        bannerView.setOnBannerItemClickListener(this);
        // 开启滚动
        bannerView.startRoll();

        mRecyclerView.addHeaderView(bannerView);
    }

    /**
     * 显示列表
     *
     * @param list
     */
    private void showListData(List<DiscoverListResult.DataBean.CategoriesBean.CategoryListBean> list) {
        final DiscoverListAdapter listAdapter = new DiscoverListAdapter(context, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(listAdapter);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    public void click(int position) {
        // 轮播点击
        Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
    }
}
