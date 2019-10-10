package com.apps.aggr.daggerappreal.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.aggr.daggerappreal.R;
import com.apps.aggr.daggerappreal.di.BaseApplication;
import com.apps.aggr.daggerappreal.model.User;
import com.apps.aggr.daggerappreal.ui.login.LoginActivity;
import com.apps.aggr.daggerappreal.ui.webService.WebServiceActivity;

import javax.inject.Inject;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, Profile.View{

    private EditText etName, etEdad;
    private TextView tvLogOut;
    private Button btnNextActivity, btUpdate;


    @Inject
    Profile.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ((BaseApplication)getApplication()).getAppComponent().inject(this);



        etEdad = findViewById(R.id.etEdad);
        etName = findViewById(R.id.etName);
        tvLogOut = findViewById(R.id.tvLogout);
        btnNextActivity = findViewById(R.id.btNextActivity);
        btUpdate = findViewById(R.id.btUpdate);

        tvLogOut.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btnNextActivity.setOnClickListener(this);

        presenter.setView(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tvLogout){
            presenter.logout();

        }
        if(v.getId() == R.id.btNextActivity){
            startActivity(new Intent(getApplicationContext(), WebServiceActivity.class));
            this.finish();

        }
        if(v.getId() == R.id.btUpdate){
            User user = new User();
            user.setEdad(etEdad.getText().toString());
            user.setUsername(etName.getText().toString());
            presenter.updateUser(user);
        }
    }

    @Override
    public void showUser(User user) {
        etEdad.setText(user.getEdad());
        etName.setText(user.getUsername());

    }

    @Override
    public void logout() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
