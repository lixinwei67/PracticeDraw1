package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

public class Practice2DrawCircleView extends View {

    Paint paint;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int quarter = getHeight() / 4;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int x1 = centerX - quarter;
        int y1 = centerY - quarter;

        int x2 = centerX + quarter;
        int y2 = centerY - quarter;

        int x3 = centerX - quarter;
        int y3 = centerY + quarter;

        int x4 = centerX + quarter;
        int y4 = centerY + quarter;

        int length = quarter - Util.dp2px(10);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x1, y1, length, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x2, y2, length, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x3, y3, length, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Util.dp2px(20));
        canvas.drawCircle(x4, y4, length, paint);
    }
}
