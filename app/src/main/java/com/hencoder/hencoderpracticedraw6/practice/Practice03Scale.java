package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static final int ANIMATIONTYPE_SCALE_X_0 = 0x00;
    public static final int ANIMATIONTYPE_SCALE_X_1 = 0x01;
    public static final int ANIMATIONTYPE_SCALE_Y_0 = 0x02;
    public static final int ANIMATIONTYPE_SCALE_Y_1 = 0x03;

    private int animationType = ANIMATIONTYPE_SCALE_X_0;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
                switch (animationType) {
                    case ANIMATIONTYPE_SCALE_X_0:
                        imageView.animate().scaleXBy(1.5f);
                        break;
                    case ANIMATIONTYPE_SCALE_X_1:
                        imageView.animate().scaleXBy(-1.5f);
                        break;
                    case ANIMATIONTYPE_SCALE_Y_0:
                        imageView.animate().scaleYBy(1.5f);
                        break;
                    case ANIMATIONTYPE_SCALE_Y_1:
                        imageView.animate().scaleYBy(-1.5f);
                        break;

                }

                animationType += 1;
                if (animationType > ANIMATIONTYPE_SCALE_Y_1) {
                    animationType = ANIMATIONTYPE_SCALE_X_0;
                }

            }
        });
    }
}
