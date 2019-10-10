package com.apps.aggr.daggerappreal.di;

import android.app.Application;

import com.apps.aggr.daggerappreal.di.components.AppComponent;
import com.apps.aggr.daggerappreal.di.components.DaggerAppComponent;
import com.apps.aggr.daggerappreal.di.modules.AppModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpGrafo();
    }

    private void setUpGrafo() {

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
