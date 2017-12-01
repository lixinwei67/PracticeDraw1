package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

public class Practice5DrawOvalView extends View {
    Paint paint;

    {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        int offsetX = Util.dp2px(70);
        int offsetY = Util.dp2px(35);

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawOval(-offsetX, -offsetY, offsetX, offsetY, paint);
        canvas.restore();
    }
}
