package com.apps.aggr.daggerappreal.api;

import com.apps.aggr.daggerappreal.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getReposForUser(@Path("user")String user);
}
