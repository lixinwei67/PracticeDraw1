package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

public class Practice8DrawArcView extends View {

    Paint paint;
    RectF rectF = new RectF();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        int offsetX = Util.dp2px(60);
        int offsetY = Util.dp2px(35);
        rectF.set(-offsetX, -offsetY, offsetX, offsetY);

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, -180, 60, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -110, 100, true, paint);

        canvas.drawArc(rectF, 15, 150, false, paint);
        canvas.restore();
    }
}
