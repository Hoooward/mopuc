package com.juzix.ai.mopuc.example;

import com.juzix.ai.mopuc.core.activities.ProxyActivity;
import com.juzix.ai.mopuc.core.delegates.MopucDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public MopucDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

}
