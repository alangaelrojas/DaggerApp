package com.apps.aggr.daggerappreal.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.aggr.daggerappreal.R;
import com.apps.aggr.daggerappreal.di.BaseApplication;
import com.apps.aggr.daggerappreal.ui.profile.ProfileActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Login.View{

    private Button btLogin;
    private EditText edtUsername, edtPassword;

    @Inject
    Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Injection
        ((BaseApplication)getApplication()).getAppComponent().inject(this);

        //Inject view
        presenter.setView(this);

        //Casting
        btLogin = findViewById(R.id.btLogin);
        edtPassword = findViewById(R.id.etPassword);
        edtUsername = findViewById(R.id.etUser);



        btLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btLogin){
            presenter.validaUser(edtUsername.getText().toString(), edtPassword.getText().toString());
        }
    }

    @Override
    public void usuarioValido() {
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        this.finish();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Usuario o contraseña invalido", Toast.LENGTH_SHORT).show();
    }


}
