package com.example.hrle.android_portal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrle.android_portal.DAO.RestAPI;
import com.example.hrle.android_portal.DAO.RetroClient;
import com.example.hrle.android_portal.DAO.RetroClientZaRead;
import com.example.hrle.android_portal.model.Content;
import com.example.hrle.android_portal.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadPostActivity extends AppCompatActivity {

    private TextView title;
    private TextView slika;
    private TextView author;
    private TextView date;
    private TextView location;
    private TextView likes;
    private TextView dislikes;
    private TextView description;
    private ListView listViewComments;
    private String tokenCeli;
    private String accessTokenizPref;
    private String tipTokenaIzPref;
    SharedPreferences mSettings;

    private long id_iz_intenta;

    Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mSettings = PreferenceManager.getDefaultSharedPreferences(ReadPostActivity.this);

        accessTokenizPref = mSettings.getString("accessToken", "");
        tipTokenaIzPref = mSettings.getString("tokenType", "");

        tokenCeli = tipTokenaIzPref + " " + accessTokenizPref;



        FrameLayout contentFrameLayout = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_read_post, contentFrameLayout);


        author = findViewById(R.id.autor);
        date = findViewById(R.id.datum);
        location = findViewById(R.id.lokacija);
        likes = findViewById(R.id.likes);
        dislikes = findViewById(R.id.dislikes);
        title = findViewById(R.id.naslov);
        slika = findViewById(R.id.slika);
        description = findViewById(R.id.opis);
        listViewComments = findViewById(R.id.lv_comments);

        Intent ii = getIntent();
        id_iz_intenta = ii.getLongExtra("id", 0);

        RestAPI rest_api = RetroClientZaRead.getRestAPI();

        Call<PostResponse> call = rest_api.getPost(id_iz_intenta, tokenCeli);

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse>call, Response<PostResponse> response) {

                if( response.isSuccessful()) {

//                    PostResponse postResponse = response.body();
//                    author.setText(postResponse.getCreatedBy().getName());
//                    date.setText(postResponse.getCreationDateTime().toString());
//                    likes.setText(postResponse.getLikes().toString());
//                    dislikes.setText(postResponse.getDislikes().toString());




                }
                else {
                    int sc = response.code();
                    switch (sc) {

                    }
                }

            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });






    }
}
