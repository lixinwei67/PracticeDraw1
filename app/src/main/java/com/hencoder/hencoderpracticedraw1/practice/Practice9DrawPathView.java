package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

public class Practice9DrawPathView extends View {

    Paint paint;
    Path path;

    {
        paint = new Paint();
        paint.setAntiAlias(true);

        path = new Path();
    }

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);

        int radius = Util.dp2px(20);
        path.addArc(-radius * 2, -radius, 0, radius, -225, 225);
        path.arcTo(0, -radius, 2 * radius, radius, -180, 225, false);
        path.lineTo(0, (float) (radius * Math.tan(67.5 * Math.PI / 180)));
        path.close();

        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
