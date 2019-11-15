package com.juzix.ai.mopuc.core.app;

import java.util.ArrayList;
import java.util.WeakHashMap;

import okhttp3.Interceptor;

public class Configurator {

    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private static final WeakHashMap<String, Object> MOPUC_CONFIGS =
            new WeakHashMap<>();

    private Configurator() {
        MOPUC_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final WeakHashMap<String, Object> getMopucConfigs() {
        return MOPUC_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        MOPUC_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        MOPUC_CONFIGS.put(ConfigType.INTERCEPTOR.name(), INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptor(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        MOPUC_CONFIGS.put(ConfigType.INTERCEPTOR.name(), INTERCEPTORS);
        return this;
    }


    public final Configurator withApiHost(String host) {
        MOPUC_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady =
                (boolean) MOPUC_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call " +
                    "configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) MOPUC_CONFIGS.get(key.name());
    }


}
