package com.example.hrle.android_portal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hrle.android_portal.DAO.RestAPI;
import com.example.hrle.android_portal.model.PostRequest;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CreatePostActivity extends AppCompatActivity  {

    String BASE_URL = "http://192.168.43.21:8080/";
    Toolbar toolbar;
    private Button dugmeZaSliku;
    private ImageView izabranaSlika;
    private String inputNaslov;
    private String inputOpis;
    EditText naslov;
    EditText opis;
    private int id_usera;
    SharedPreferences mSettings;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        mSettings = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        id_usera = mSettings.getInt("id", 0);

        FrameLayout contentFrameLayout = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_create_post, contentFrameLayout);

        toolbar = findViewById(R.id.toolbar_cp);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        naslov = findViewById(R.id.etNaslov);
        opis = findViewById(R.id.etOpis);
        izabranaSlika = findViewById(R.id.izabranaSlika);
        dugmeZaSliku = findViewById(R.id.dugmeZaSliku);

        dugmeZaSliku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();

            }
        });



    }

    private void openGallery(){

        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);



    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            izabranaSlika.setImageURI(imageUri);

        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_post_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == android.R.id.home) {
//            onBackPressed();
//            return true;
//        }
//        if (id == R.id.action_confirm) {
//            inputNaslov = naslov.getText().toString().trim();
//            inputOpis = opis.getText().toString().trim();
//
//            PostRequest postDTO_a = new PostRequest(inputNaslov, inputOpis, 0,0, "Novi Sad", "cartman.jpg", "");
//            sendNetworkRequest(id_usera, postDTO_a);
//
//
//        }
//        if (id == R.id.action_cancel) {
//            Toast.makeText(getApplicationContext(), "Odustali ste od pravljenja objave",
//                    Toast.LENGTH_LONG).show();
//            Intent i =  new Intent(CreatePostActivity.this, PostsActivity.class);
//            startActivity(i);
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void sendNetworkRequest(int userId , PostRequest postDTO) {
//
//        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
//
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        okHttpClientBuilder.addInterceptor(logging);
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClientBuilder.build());
//
//        Retrofit retrofit = builder.build();
//
//        RestAPI client = retrofit.create(RestAPI.class);
//
//        Call<PostRequest> call = client.createPost(userId, postDTO);
//
//
//        call.enqueue(new Callback<PostRequest>() {
//            @Override
//            public void onResponse(Call<PostRequest> call, Response<PostRequest> response) {
//                Toast.makeText(getApplicationContext(), "Uspesno ste napravili objavu",
//                        Toast.LENGTH_LONG).show();
//                Intent i = new Intent(CreatePostActivity.this, PostsActivity.class);
//                startActivity(i);
//
//            }
//
//            @Override
//            public void onFailure(Call<PostDTO> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Uspesno ste napravili objavu",
//                        Toast.LENGTH_LONG).show();
//                Intent i = new Intent(CreatePostActivity.this, PostsActivity.class);
//                startActivity(i);
//            }
//        });
//    }
//


}
