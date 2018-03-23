package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static final int ANIMATIONTYPE_TO_ROTATION_0 = 0x00;
    public static final int ANIMATIONTYPE_TO_ROTATION_1 = 0x01;
    public static final int ANIMATIONTYPE_TO_ROTATION_X_0 = 0x02;
    public static final int ANIMATIONTYPE_TO_ROTATION_X_1 = 0x03;
    public static final int ANIMATIONTYPE_TO_ROTATION_Y_0 = 0x04;
    public static final int ANIMATIONTYPE_TO_ROTATION_Y_1 = 0x05;
    private int animationType = ANIMATIONTYPE_TO_ROTATION_0;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (animationType) {
                    case ANIMATIONTYPE_TO_ROTATION_0:
                        imageView.animate().rotationBy(180);
                        break;
                    case ANIMATIONTYPE_TO_ROTATION_1:
                        imageView.animate().rotationBy(-180);
                        break;
                    case ANIMATIONTYPE_TO_ROTATION_X_0:
                        imageView.animate().rotationXBy(180);
                        break;
                    case ANIMATIONTYPE_TO_ROTATION_X_1:
                        imageView.animate().rotationXBy(-180);
                        break;
                    case ANIMATIONTYPE_TO_ROTATION_Y_0:
                        imageView.animate().rotationYBy(180);
                        break;
                    case ANIMATIONTYPE_TO_ROTATION_Y_1:
                        imageView.animate().rotationYBy(-180);
                        break;
                }

                animationType += 1;
                if (animationType > ANIMATIONTYPE_TO_ROTATION_Y_1) {
                    animationType = ANIMATIONTYPE_TO_ROTATION_0;
                }


            }
        });
    }
}