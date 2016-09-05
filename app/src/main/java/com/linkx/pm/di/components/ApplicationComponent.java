package com.linkx.pm.di.components;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import com.linkx.pm.di.modules.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}
