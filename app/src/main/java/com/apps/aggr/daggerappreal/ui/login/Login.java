package com.apps.aggr.daggerappreal.ui.login;

public interface Login {

    interface View{
        void usuarioValido();
        void error();
    }

    interface Presenter{
        void validaUser(String user, String pass);
        void setView(Login.View view);

    }
}
