package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;
import com.hencoder.hencoderpracticedraw1.Util;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

    Paint paint;
    Paint linePaint;
    private List<Data> dataList;
    private float sum = 0;
    private float max = 0;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//反锯齿
        paint.setStyle(Paint.Style.FILL);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(Util.dp2px(.5f));

        dataList = new ArrayList<>();
        dataList.add(new Data("Froyo", "Froyo", 1L, Color.parseColor("#FFFFFF")));
        dataList.add(new Data("GB", "Gingerbread", 10L, Color.parseColor("#9C27B0")));
        dataList.add(new Data("ICS", "Ice Cream Sandwich", 10L, Color.parseColor("#9E9E9E")));
        dataList.add(new Data("JB", "Jelly Bean", 100L, Color.parseColor("#009688")));
        dataList.add(new Data("KitKat", "KitKat", 160L, Color.parseColor("#03A9F4")));
        dataList.add(new Data("L", "Lollipop", 200L, Color.parseColor("#FF5722")));
        dataList.add(new Data("M", "Marshmallow", 80L, Color.parseColor("#FFC107")));

        for (Data data : dataList) {
            sum += data.getWeight();
            max = Math.max(max, data.getWeight());
        }

    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);

        int radius = getWidth() / 2 - Util.dp2px(100);
        float startAngle = 0;
        float sweepAngle;

        for (Data data : dataList) {
            sweepAngle = 360 * data.getWeight() / sum;
            sweepAngle = Math.max(1, sweepAngle);
            paint.setColor(data.getColor());

            if (max == data.getWeight()) {
                canvas.save();
                canvas.translate(-20, -20);
            }
            canvas.drawArc(-radius, -radius, radius, radius, startAngle, sweepAngle - 1, true, paint);

            if (max == data.getWeight()) {
                canvas.restore();
            }

            startAngle += sweepAngle;
        }


        canvas.restore();
    }
}
