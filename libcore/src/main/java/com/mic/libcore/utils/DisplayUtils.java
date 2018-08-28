package com.mic.libcore.utils;

import android.content.Context;
import android.util.TypedValue;

public class DisplayUtils {


    public static int spTopx(int sp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,sp,context.getResources().getDisplayMetrics());
    }


}
