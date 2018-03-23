package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

import static android.os.Build.VERSION.SDK_INT;
import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

public class Practice01Translation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    public Practice01Translation(Context context) {
        super(context);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public static final int ANIMATION_TYPE_TO_RIGHT = 0x00;
    public static final int ANIMATION_TYPE_TO_LEFT = 0x01;
    public static final int ANIMATION_TYPE_TO_BOTTOM = 0x02;
    public static final int ANIMATION_TYPE_TO_TOP = 0x03;

    private int animationType = ANIMATION_TYPE_TO_RIGHT;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移

                //translationX 都是在原来坐标的基础上进行的偏移
                //例如原坐标 0.0 往右100 然后再-100 并不是回到了原位置 而是去到了-100的位置
                //而translationXBy 就可以达到先100 后-100 之后回到原位置的效果
                switch (animationType) {
                    case ANIMATION_TYPE_TO_RIGHT:
                        imageView.animate().translationXBy(100);
                        break;
                    case ANIMATION_TYPE_TO_LEFT:
                        imageView.animate().translationXBy(-100);
                        break;
                    case ANIMATION_TYPE_TO_BOTTOM:
                        imageView.animate().translationYBy(100);
                        break;
                    case ANIMATION_TYPE_TO_TOP:
                        imageView.animate().translationYBy(-100);
                        break;
                }
                animationType += 1;
                if (animationType > ANIMATION_TYPE_TO_TOP) {
                    animationType = ANIMATION_TYPE_TO_RIGHT;
                }
            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}