package com.linkx.pm.di.components;

import android.app.Activity;
import android.app.Application;
import dagger.Component;
import com.linkx.pm.di.ActivityScope;
import com.linkx.pm.di.modules.ActivityModule;

@ActivityScope
@Component(dependencies = Application.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
