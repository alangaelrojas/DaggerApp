package com.apps.aggr.daggerappreal.ui.profile;

import com.apps.aggr.daggerappreal.model.User;

public class ProfilePresenter implements Profile.Presenter{

    private User user;
    private Profile.View view;

    public ProfilePresenter(User user){
        this.user = user;
    }

    @Override
    public void setView(Profile.View view) {
        this.view = view;
        view.showUser(user);
    }

    @Override
    public void updateUser(User updateUser) {

        user.setUsername(updateUser.getUsername());
        user.setEdad(updateUser.getEdad());
    }

    @Override
    public void logout() {
        user.setUsername("");
        user.setEdad("");
        view.logout();
    }
}
