package com.juzix.ai.mopuc.example;

import android.app.Application;

import com.juzix.ai.mopuc.core.app.Mopuc;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Mopuc.init(this).
                withApiHost("https://www.baidu.com").
                configure();

    }
}
