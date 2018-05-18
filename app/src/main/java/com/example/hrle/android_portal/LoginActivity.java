package com.example.hrle.android_portal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hrle.android_portal.DAO.RestAPI;
import com.example.hrle.android_portal.DAO.RetroClient;
import com.example.hrle.android_portal.model.Post;
import com.example.hrle.android_portal.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_btn;
    private List<User> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username_etext);
        password = findViewById(R.id.password_etext);
        login_btn = findViewById(R.id.login_btn);

        RestAPI rest_api = RetroClient.getRestAPI();

        Call<List<User>> call = rest_api.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if( response.isSuccessful()) {



//                    JSONObject mJsonObject = new JSONObject(response.body());
//                    JSONArray mJsonArray = mJsonObject.getJSONArray("array")
//
//                    String username = mJsonObject.getString("username");
//                    String password = mJsonObject.getString("password");

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });

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

    public void btnStartPostsActivity(View view) {
        Intent i = new Intent(this, PostsActivity.class);
        startActivity(i);
        finish();
    }


    public void login() {





    }


}
