package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    Paint mLinePaint;
    Paint mRectPaint;

    Path mLinePath;

    int padding = 15;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(2);

        mLinePath = new Path();
        mLinePath.moveTo(100, 100);
        mLinePath.lineTo(100, 600);
        mLinePath.rLineTo(800, 0);


        mRectPaint = new Paint();
        mRectPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //画坐标系
        canvas.drawPath(mLinePath, mLinePaint);
        String[] lables = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
        int[] rectHeight = {10, 25, 25, 105, 180, 220, 85};
        int firstPoint = 100 + padding;//X坐标起始点
        int oneWidth = 100;//一个矩形的宽

        for (int i = 0; i < lables.length; i++) {
            Rect rect = new Rect();
            mLinePaint.getTextBounds(lables[i], 0, lables[i].length(), rect);
            int w = rect.width();
//            int h = rect.height();
            canvas.drawText(lables[i], firstPoint + i * oneWidth + i * padding + (oneWidth / 2 - w / 2), 600 + 20, mLinePaint);//text
            //rect
            RectF rectF = new RectF(firstPoint + i * oneWidth + i * padding, 600 - rectHeight[i], firstPoint + (i + 1) * oneWidth + i * padding, 600);
            canvas.drawRect(rectF, mRectPaint);
        }

    }
}
