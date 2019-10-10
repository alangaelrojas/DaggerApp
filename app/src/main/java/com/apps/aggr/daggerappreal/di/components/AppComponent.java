package com.apps.aggr.daggerappreal.di.components;

import com.apps.aggr.daggerappreal.di.modules.AppModule;
import com.apps.aggr.daggerappreal.ui.login.LoginActivity;
import com.apps.aggr.daggerappreal.ui.profile.ProfileActivity;
import com.apps.aggr.daggerappreal.ui.webService.WebServiceActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(LoginActivity loginActivity);
    void inject(ProfileActivity profileActivity);
    void inject(WebServiceActivity webServiceActivity);
}
