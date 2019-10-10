package com.apps.aggr.daggerappreal.ui.webService;

import com.apps.aggr.daggerappreal.model.User;

public interface WebService {

    interface View{
        void showUser(User user);
    }
    interface Presenter{
        void setView(WebService.View view);
        void solicitudWebService();
    }
}
