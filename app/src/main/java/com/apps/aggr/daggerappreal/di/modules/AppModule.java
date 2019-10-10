package com.apps.aggr.daggerappreal.di.modules;

import android.app.Application;
import android.content.Context;

import com.apps.aggr.daggerappreal.api.ApiClient;
import com.apps.aggr.daggerappreal.model.User;
import com.apps.aggr.daggerappreal.ui.login.Login;
import com.apps.aggr.daggerappreal.ui.login.LoginPresenter;
import com.apps.aggr.daggerappreal.ui.profile.Profile;
import com.apps.aggr.daggerappreal.ui.profile.ProfilePresenter;
import com.apps.aggr.daggerappreal.ui.webService.WebService;
import com.apps.aggr.daggerappreal.ui.webService.WebServicePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    public Context ŕpvideApplicationContext(){
        return application;
    }

    /*User*/

    @Provides
    @Singleton
    public User providesUser(){
        return new User();
    }

    /* Retrofit*/

    private static final String BASE_URL = "https://api.github.com";

    @Singleton
    @Provides
    GsonConverterFactory providesGsonConverterFactory(){
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        return gsonConverterFactory;
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    ApiClient provideApiCliente(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }


    /*Grafo de activities*/

    @Provides
    @Singleton
    Login.Presenter providePresenterLogin(User user){
        return new LoginPresenter(user);
    }

    @Provides
    @Singleton
    Profile.Presenter providePresenterProfile(User user){
        return new ProfilePresenter(user);
    }

    @Singleton
    @Provides
    WebService.Presenter providePresenterWebService(User user, ApiClient apiClient){
        return new WebServicePresenter(user, apiClient);
    }


}
