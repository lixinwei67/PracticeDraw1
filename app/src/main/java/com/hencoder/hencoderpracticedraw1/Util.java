package com.hencoder.hencoderpracticedraw1;

import android.content.res.Resources;

/**
 * @author lixinwei
 */
public class Util {

    public static int dp2px(float value) {
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (value * scale + 0.5f);
    }

    public static int sp2px(float value) {
        float scale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (value * scale + 0.5f);
    }
}
