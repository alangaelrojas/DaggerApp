package com.apps.aggr.daggerappreal.ui.webService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apps.aggr.daggerappreal.R;
import com.apps.aggr.daggerappreal.di.BaseApplication;
import com.apps.aggr.daggerappreal.model.User;
import com.apps.aggr.daggerappreal.ui.profile.ProfileActivity;

import javax.inject.Inject;

public class WebServiceActivity extends AppCompatActivity implements View.OnClickListener, WebService.View {

    private Button btVolver, btWebService;
    private TextView tvName, tvEdad;

    @Inject
    WebService.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        ((BaseApplication)getApplication()).getAppComponent().inject(this);

        btVolver = findViewById(R.id.btVolverAProfile);
        btWebService = findViewById(R.id.btHacerPeticionWeb);
        tvEdad = findViewById(R.id.tvEdad);
        tvName = findViewById(R.id.tvUserName);


        btWebService.setOnClickListener(this);
        btVolver.setOnClickListener(this);

        presenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btVolverAProfile){
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            this.finish();
        }else if(v.getId() == R.id.btHacerPeticionWeb){
            presenter.solicitudWebService();

        }
    }

    @Override
    public void showUser(User user) {
        tvEdad.setText(user.getEdad());
        tvName.setText(user.getUsername());
    }
}
