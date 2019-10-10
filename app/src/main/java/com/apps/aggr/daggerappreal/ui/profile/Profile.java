package com.apps.aggr.daggerappreal.ui.profile;

import com.apps.aggr.daggerappreal.model.User;

public interface Profile {

    interface View{
        void showUser(User user);
        void logout();
    }

    interface Presenter{
        void setView(Profile.View view);
        void updateUser(User updateUser);
        void logout();
    }
}
