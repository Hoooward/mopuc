package com.juzix.ai.mopuc.core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.juzix.ai.mopuc.core.app.Mopuc;

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Mopuc.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Mopuc.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
