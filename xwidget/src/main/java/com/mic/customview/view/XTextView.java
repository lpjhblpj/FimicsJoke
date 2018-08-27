package com.mic.customview.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.mic.xwidget.R;


@SuppressLint("AppCompatCustomView")
@SuppressWarnings("unused")
public class XTextView extends TextView {

    private String mText;
    private int mSize = 20;
    private int mColor = Color.RED;


    /**
     * 通过代码调用
     * @param context
     */
    public XTextView(Context context) {
        this(context,null);
    }

    /**
     * 在xml中调用
     * @param context
     * @param attrs
     */
    public XTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 在xml 中但会有 style才会调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public XTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, com.mic.libcore.R.styleable.TextView);

        mText = array.getString(R.styleable.TextView_text);
        mSize = array.getDimensionPixelSize(R.styleable.TextView_size,mSize);
        mColor =array.getColor(R.styleable.TextView_color,mColor);

        array.recycle();

    }

    /**
     * 测量布局的宽高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int hightMode = MeasureSpec.getMode(heightMeasureSpec);
    }


    /**
     * 用于绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawText("");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                    break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onTouchEvent(event);

    }
}
