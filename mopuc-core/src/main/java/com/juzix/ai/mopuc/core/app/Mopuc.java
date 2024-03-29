package com.juzix.ai.mopuc.core.app;

import android.content.Context;

import java.util.WeakHashMap;

public final class Mopuc {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),
                context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getMopucConfigs();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }


}
