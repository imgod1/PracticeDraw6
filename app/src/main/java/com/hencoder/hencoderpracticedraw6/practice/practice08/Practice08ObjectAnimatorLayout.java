package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static final int ANIMATIONTYPE_0 = 0x00;
    public static final int ANIMATIONTYPE_1 = 0x01;
    private int animationType = ANIMATIONTYPE_0;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
                // 1. 用 ObjectAnimator 创建 Animator 对象
                // 2. 用 start() 执行动画
                // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！

                if (ANIMATIONTYPE_0 == animationType) {
                    animationType = ANIMATIONTYPE_1;
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "progress", 0, 100);
                    objectAnimator.start();
                } else {
                    animationType = ANIMATIONTYPE_0;
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "progress", 100, 0);
                    objectAnimator.start();
                }
            }
        });
    }
}
