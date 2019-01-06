package com.mic.video.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.Loader;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mic.video.R;
import com.mic.video.player.LocalPlayerActivity;
import com.mic.video.player.VideoItemLoader;
import com.mic.video.player.VideoListAdapter;
import com.mic.video.utils.MediaItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

@SuppressWarnings("all")
public class VideoBrowserFragment extends Fragment implements VideoListAdapter.ItemClickListener,
        android.support.v4.app.LoaderManager.LoaderCallbacks<List<MediaItem>> {


    private static final String TAG = "VideoBrowserFragment";
    private static final String CATALOG_URL =
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/f.json";
    private RecyclerView mRecyclerView;
    private VideoListAdapter mAdapter;
    private View mEmptyView;
    private View mLoadingView;

    public VideoBrowserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.video_browser_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.list);
        mEmptyView = getView().findViewById(R.id.empty_view);
        mLoadingView = getView().findViewById(R.id.progress_indicator);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new VideoListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void itemClicked(View v, MediaItem item, int position) {  String transitionName = getString(R.string.transition_image);
        VideoListAdapter.ViewHolder viewHolder =
                (VideoListAdapter.ViewHolder) mRecyclerView.findViewHolderForPosition(position);
        Pair<View, String> imagePair = Pair
                .create((View) viewHolder.getImageView(), transitionName);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(getActivity(), imagePair);

        Intent intent = new Intent(getActivity(), LocalPlayerActivity.class);
        intent.putExtra("media", item.toBundle());
        intent.putExtra("shouldStart", false);
        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }

    @NonNull
    @Override
    public Loader onCreateLoader(int i, @Nullable Bundle bundle) {
        return new VideoItemLoader(getActivity(), CATALOG_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<MediaItem>> loader, List<MediaItem> data) {
        mAdapter.setData(data);
        mLoadingView.setVisibility(View.GONE);
        mEmptyView.setVisibility(null == data || data.isEmpty() ? View.VISIBLE : View.GONE);
    }


    @Override
    public void onLoaderReset(@NonNull Loader loader) {
        mAdapter.setData(null);
    }
}
