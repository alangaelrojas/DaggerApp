package com.apps.aggr.daggerappreal.ui.webService;

import android.util.Log;

import com.apps.aggr.daggerappreal.api.ApiClient;
import com.apps.aggr.daggerappreal.model.GitHubRepo;
import com.apps.aggr.daggerappreal.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServicePresenter implements WebService.Presenter{

    private User user;
    private ApiClient api;
    private WebService.View view;

    public WebServicePresenter(User user, ApiClient api) {
        this.user = user;
        this.api = api;
    }

    @Override
    public void setView(WebService.View view) {
        this.view = view;
        view.showUser(user);

    }

    @Override
    public void solicitudWebService() {
        Call<List<GitHubRepo>> call = api.getReposForUser("alangaelrojas");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                for(int i =0; i<response.body().size();i++){
                    GitHubRepo repo = response.body().get(i);
                    Log.d("TAG1", "Repositorio: "+i+" nombre: "+repo.getName() + " avatar: "+repo.getOwner().getAvatarUrl() + " login: "+repo
                    .getOwner().getLogin());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}
