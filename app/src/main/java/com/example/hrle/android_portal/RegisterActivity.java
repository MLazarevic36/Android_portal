package com.example.hrle.android_portal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hrle.android_portal.DAO.RestAPI;
import com.example.hrle.android_portal.model.LoginRequest;
import com.example.hrle.android_portal.model.RegisterRequest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private String BASE_URL = "http://192.168.0.12:8080/";
    private EditText name_et;
    private EditText username_et;
    private EditText lozinka_et;
    private Button register_btn;
    private String inputName;
    private String inputUsername;
    private String inputPassword;
    private String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name_et = findViewById(R.id.name_et);
        username_et = findViewById(R.id.username_et);
        lozinka_et = findViewById(R.id.lozinka_et);
        register_btn = findViewById(R.id.register_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName = name_et.getText().toString();
                inputUsername = username_et.getText().toString();
                inputPassword = lozinka_et.getText().toString();
                photo = "cartman.jpg";
                RegisterRequest registerRequest = new RegisterRequest(inputName, inputUsername, inputPassword, photo);
                registracija(registerRequest);
            }
        });



    }



    private void registracija(RegisterRequest registerRequest) {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClientBuilder.addInterceptor(logging);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build());

        Retrofit retrofit = builder.build();

        RestAPI client = retrofit.create(RestAPI.class);

        Call<RegisterRequest> call = client.signUp(registerRequest);

        call.enqueue(new Callback<RegisterRequest>() {
            @Override
            public void onResponse(Call<RegisterRequest> call, Response<RegisterRequest> response) {
                if (response.code() == 201) {
                    Toast.makeText(getApplicationContext(), "Uspesno ste se registrovali",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Doslo je do greske",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterRequest> call, Throwable t) {


            }
        });


    }


}
