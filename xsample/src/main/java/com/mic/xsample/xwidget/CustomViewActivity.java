package com.mic.xsample.xwidget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;

import com.mic.customview.view.QQStepView;
import com.mic.xsample.R;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/4/23.
 * Version 1.0
 * Description:
 */
public class CustomViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        testQQStepView();
    }

    private void testQQStepView(){
        final QQStepView qqStepView = (QQStepView) findViewById(R.id.step_view);
        qqStepView.setStepMax(4000);

        // 属性动画 后面讲的内容
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 2000);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentStep = (float) animation.getAnimatedValue();
                qqStepView.setCurrentStep((int)currentStep);
            }
        });
        valueAnimator.start();
    }
}
