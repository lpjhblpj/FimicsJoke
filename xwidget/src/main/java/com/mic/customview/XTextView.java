package com.mic.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressWarnings("unused")
public class XTextView extends TextView {


    /**
     * 通过代码调用
     * @param context
     */
    public XTextView(Context context) {
        super(context);
    }

    /**
     * 在xml中调用
     * @param context
     * @param attrs
     */
    public XTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 在xml 中但会有 style才会调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public XTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
