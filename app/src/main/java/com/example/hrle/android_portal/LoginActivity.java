package com.example.hrle.android_portal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrle.android_portal.DAO.RestAPI;
import com.example.hrle.android_portal.model.LoginRequest;
import com.example.hrle.android_portal.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private String BASE_URL = "http://192.168.0.18:8080/";
    Retrofit retrofit;
    private int user_id_za_pref;
    private String usernameApi;
    private String passwordApi;
    private EditText usernameet;
    private EditText passwordet;
    private Button login_btn;
    private List<User> users = new ArrayList<User>();
    private List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
    private String usernameInput;
    private String passwordInput;
    private String rezultat;
    private TextView register_tv;
    SharedPreferences mSettings;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameet = findViewById(R.id.username_etext);
        passwordet = findViewById(R.id.password_etext);
        login_btn = findViewById(R.id.login_btn);
        register_tv = findViewById(R.id.register_tv);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameInput = usernameet.getText().toString();
                passwordInput = passwordet.getText().toString();
                LoginRequest loginRequest = new LoginRequest(usernameInput, passwordInput);
                login(loginRequest);
            }
        });
        register_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        //getRetrofitArray();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void login(final LoginRequest loginRequest) {

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

        Call<LoginRequest> call = client.signIn(loginRequest);

        call.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                if (response.code() == 200 && response.body() != null) {

                    Intent i = new Intent(LoginActivity.this, PostsActivity.class);

                    Toast.makeText(getApplicationContext(), "Uspesna prijava",
                            Toast.LENGTH_LONG).show();


                    LoginRequest loginRequest = response.body();

                    String token = loginRequest.getAccessToken();
                    String tip = loginRequest.getTokenType();


                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("accessToken", token);
                    editor.putString("tokenType", tip);
                    editor.apply();
//
//
//
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Uneti podaci nisu dobri",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {


            }
        });


    }






}
