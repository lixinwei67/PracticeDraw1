package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;
import com.hencoder.hencoderpracticedraw1.Util;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    Paint paint;

    TextPaint textPaint;

    List<Data> dataList;

    float sum = 0;

    int rectangleWidth = Util.dp2px(30);
    int space = Util.dp2px(5);

    int textHeight;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(Util.dp2px(0.5f));

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(Util.sp2px(10));
        textPaint.setTextAlign(Paint.Align.CENTER);

        textHeight = (int) -textPaint.ascent();

        dataList = new ArrayList<>();
        dataList.add(new Data("Froyo", "Froyo", 1L, Color.GREEN));
        dataList.add(new Data("GB", "Gingerbread", 10L, Color.GREEN));
        dataList.add(new Data("ICS", "Ice Cream Sandwich", 10L, Color.GREEN));
        dataList.add(new Data("JB", "Jelly Bean", 100L, Color.GREEN));
        dataList.add(new Data("KitKat", "KitKat", 180L, Color.GREEN));
        dataList.add(new Data("L", "Lollipop", 200L, Color.GREEN));
        dataList.add(new Data("M", "Marshmallow", 80L, Color.GREEN));

        for (Data data : dataList) {
            sum += data.getWeight();
        }
    }

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        int horizontalPadding = Util.dp2px(80);
        int verticalPadding = Util.dp2px(40);

        int top = verticalPadding;
        int left = horizontalPadding;
        int bottom = getHeight() - 3 * verticalPadding;
        int right = getWidth() - horizontalPadding;

        canvas.drawLine(left, top, left, bottom, paint);
        canvas.drawLine(left, bottom, right, bottom, paint);

        paint.setStyle(Paint.Style.FILL);

        for (int i = 0; i < dataList.size(); i++) {
            Data data = dataList.get(i);
            int rectCenterX = left + space + rectangleWidth / 2 + i * (space + rectangleWidth);
            paint.setColor(data.getColor());
            canvas.drawRect(rectCenterX - rectangleWidth / 2, bottom - Util.dp2px(400) * data.getWeight() / sum, rectCenterX + rectangleWidth / 2, bottom, paint);

            canvas.drawText(data.getLabel(), rectCenterX, bottom + textHeight, textPaint);
        }
    }
}
