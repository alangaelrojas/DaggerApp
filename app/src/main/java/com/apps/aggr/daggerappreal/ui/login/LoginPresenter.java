package com.apps.aggr.daggerappreal.ui.login;

import com.apps.aggr.daggerappreal.model.User;

public class LoginPresenter implements Login.Presenter{


    private Login.View view;

    private User user;

    public LoginPresenter(User user){
        this.user = user;

    }
    @Override
    public void setView(Login.View view) {
        this.view = view;
    }

    @Override
    public void validaUser(String username, String pass) {
        if(view != null){
            if(username.equals("alan") && pass.equals("1234")){
                user.setUsername("Alan Gael Rojas");
                user.setEdad("23");
                view.usuarioValido();
            }else{
                view.error();
            }
        }
    }
}
