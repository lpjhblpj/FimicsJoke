package com.mic.optimization.common;

import android.view.View;

import com.mic.optimization.view.LeakView;

import java.util.WeakHashMap;

public class ListenerCollector {

    static private WeakHashMap<View, LeakView.MyListener> sListener = new WeakHashMap<>();

    public void  setsListener(View view,LeakView.MyListener listener){
        sListener.put(view,listener);
    }

    public static void clearListener(){
        sListener.clear();
    }
}
