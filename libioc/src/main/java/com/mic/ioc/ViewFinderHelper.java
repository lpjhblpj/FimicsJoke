package com.mic.ioc;

import android.app.Activity;
import android.view.View;


@SuppressWarnings("unused")
public class ViewFinderHelper {

    private Activity mActivity;
    private View mView;

    public ViewFinderHelper(Activity activity) {
        this.mActivity = activity;
    }

    public ViewFinderHelper(View view) {
        this.mView = view;
    }

    public View findViewById(int viewId){
        return mActivity!=null? mActivity.findViewById(viewId):mView.findViewById(viewId);
    }
}
