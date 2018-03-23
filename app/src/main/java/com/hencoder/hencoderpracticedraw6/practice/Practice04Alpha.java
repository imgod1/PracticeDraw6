package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice04Alpha extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public static final int ANIMATIONTYPE_0 = 0x00;
    public static final int ANIMATIONTYPE_1 = 0x01;
    private int animationType = ANIMATIONTYPE_0;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);


        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
                switch (animationType) {
                    case ANIMATIONTYPE_0:
                        imageView.animate().alpha(0);
                        break;
                    case ANIMATIONTYPE_1:
                        imageView.animate().alpha(1);
                        break;

                }
                animationType += 1;
                if (animationType > ANIMATIONTYPE_1) {
                    animationType = ANIMATIONTYPE_0;
                }

            }
        });
    }
}