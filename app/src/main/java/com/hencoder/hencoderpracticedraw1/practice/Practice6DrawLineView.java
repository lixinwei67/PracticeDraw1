package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

public class Practice6DrawLineView extends View {

    Paint paint;

    {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
    }

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        int offset = Util.dp2px(50);

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawLine(-offset, -offset, offset, offset, paint);
        canvas.restore();
    }
}
