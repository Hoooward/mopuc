package com.juzix.ai.mopuc.example;

import com.juzix.ai.mopuc.core.activities.ProxyActivity;
import com.juzix.ai.mopuc.core.delegates.MopucDelegate;
import com.juzix.ai.mopuc.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public MopucDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

}
