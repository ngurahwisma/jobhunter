package com.wisma.jobhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wisma.jobhunter.Fragment.DialogTanggal;
import com.wisma.jobhunter.Services.ApiClient;
import com.wisma.jobhunter.Services.Model.ServerDefaultResponse;
import com.wisma.jobhunter.Services.Services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNama,etUsername,etEmail,etNohp,etBio,etPassword;
    public static TextView tvTanggal;
    private Button btnSubmit,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.etNama = findViewById(R.id.etRegisterNama);
        this.etUsername  = findViewById(R.id.etRegisterUsername);
        this.etEmail =  findViewById(R.id.etRegisterEmail);
        this.etPassword  = findViewById(R.id.etRegisterPassword);
        this.etNohp = findViewById(R.id.etRegisterNo_hp);
        this.etBio = findViewById(R.id.etRegisterBio);

        tvTanggal = findViewById(R.id.tvRegisterTanggalLahir);
        tvTanggal.setOnClickListener(this);

        this.btnSubmit =  findViewById(R.id.btnRegisterRegister);
        this.btnCancel = findViewById(R.id.btnRegisterCancel);

        this.btnSubmit.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.tvRegisterTanggalLahir){
            DialogTanggal dialogTanggal = new DialogTanggal();
            FragmentManager fragmentManager = getSupportFragmentManager();
            dialogTanggal.show(fragmentManager,"Tanggal");
        }
        else if(view.getId() == R.id.btnRegisterRegister){
            Toast.makeText(this, "MOHON TUNGGU SAMBIL NGOPI", Toast.LENGTH_SHORT).show();
            Services services = ApiClient.getRetrofit().create(Services.class);
            Call<ServerDefaultResponse> call = services.register(
                    this.etNama.getText().toString(),
                    this.etUsername.getText().toString(),
                    this.etPassword.getText().toString(),
                    this.etEmail.getText().toString(),
                    this.etNohp.getText().toString(),
                    this.etBio.getText().toString(),
                    tvTanggal.getText().toString()
            );

            call.enqueue(new Callback<ServerDefaultResponse>() {
                @Override
                public void onResponse(Call<ServerDefaultResponse> call, Response<ServerDefaultResponse> response) {
                    if(response.body().getStatus().matches("200")){
                        Toast.makeText(RegisterActivity.this, "SUKSES DAFTAR", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServerDefaultResponse> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}