package com.juzix.ai.mopuc.example;

import android.app.Application;

import com.juzix.ai.mopuc.core.app.Mopuc;
import com.juzix.ai.mopuc.core.net.interceptors.DebugInterceptor;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Mopuc.init(this)
                .withApiHost("https://127.0.0.1")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();

    }
}
