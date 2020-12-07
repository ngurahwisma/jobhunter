package com.wisma.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wisma.jobhunter.Services.ApiClient;
import com.wisma.jobhunter.Services.Model.Users;
import com.wisma.jobhunter.Services.Services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername,etPassword;
    private Button btnDaftar,btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnDaftar = findViewById(R.id.btnLoginDaftar);
        this.btnSubmit = findViewById(R.id.btnLoginLogin);

        this.etUsername = findViewById(R.id.etLoginUsername);
        this.etPassword = findViewById(R.id.etLoginPassword);

        this.btnDaftar.setOnClickListener(this);
        this.btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View viewx) {
        if(viewx.getId()  == R.id.btnLoginLogin){
            Services services = ApiClient.getRetrofit().create(Services.class);
            Call<Users> call = services.login(
                    this.etUsername.getText().toString(),
                    this.etPassword.getText().toString()
            );

            call.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    if(response.body().getStatus().matches("200")){
                        Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "GAGAL MASUK", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
        else if(viewx.getId() == R.id.btnLoginDaftar){
                    Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                    startActivity(intent);
        }
    }
}