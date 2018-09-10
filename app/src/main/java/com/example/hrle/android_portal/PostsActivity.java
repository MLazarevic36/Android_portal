package com.example.hrle.android_portal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrle.android_portal.Adapters.PostListViewAdapter;
import com.example.hrle.android_portal.DAO.Constants;
import com.example.hrle.android_portal.DAO.RestAPI;
import com.example.hrle.android_portal.DAO.RetroClient;
import com.example.hrle.android_portal.DAO.RetroClientZaRead;
import com.example.hrle.android_portal.Fragments.ReadPostFragment;
import com.example.hrle.android_portal.model.Content;
import com.example.hrle.android_portal.model.Example;
import com.example.hrle.android_portal.model.Post;
import com.example.hrle.android_portal.model.PostResponse;
import com.example.hrle.android_portal.model.PostsList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PostsActivity extends AppCompatActivity implements PostListViewAdapter.PostClickListener  {

    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    private List<Content> postsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PostListViewAdapter pAdapter;
    private ImageView avatar;
    private TextView ulogovaniUser;
    SharedPreferences mSettings;
    private String username_iz_pref;
    private String photo_iz_pref;
    private int id_iz_pref;
    private String accessTokenizPref;
    private String tipTokenaIzPref;
    private String tokenCeli;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        configViews();

        mSettings = PreferenceManager.getDefaultSharedPreferences(PostsActivity.this);

        accessTokenizPref = mSettings.getString("accessToken", "");
        tipTokenaIzPref = mSettings.getString("tokenType", "");

        tokenCeli = tipTokenaIzPref + " " + accessTokenizPref;


        Log.d(tokenCeli , "evo ga ceo token");



        RestAPI rest_api = RetroClientZaRead.getRestAPI();
        Call<Example> call = rest_api.getPosts(tokenCeli);


        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example>  call, Response<Example> response) {

                if( response.isSuccessful()) {
                    postsList.clear();




                    postsList = response.body().getContent();




                    for(int i = 0; i < postsList.size(); i++) {
                        Content content = postsList.get(i);
                        pAdapter.addPost(content);
                    }


                }
                else {
                    int sc = response.code();
                    switch (sc) {

                    }
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        switch (id){
                            case R.id.all_posts:
                                Intent i = new Intent(PostsActivity.this, PostsActivity.class);
                                startActivity(i);
                                break;
                            case R.id.create_post:
                                Intent inte = new Intent(PostsActivity.this, CreatePostActivity.class);
                                startActivity(inte);
                                break;
                            case R.id.settings:
                                Intent in = new Intent(PostsActivity.this, SettingsActivity.class);
                                startActivity(in);
                                break;
                            case R.id.logout:
                                Intent inten = new Intent(PostsActivity.this, LoginActivity.class);
                                startActivity(inten);
                                break;
                        }

                        mDrawerLayout.closeDrawers();

                        return true;
                    }
                }
        );

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {

                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {

                    }
                }
        );
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                Intent i = new Intent(PostsActivity.this, SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.action_add:
                Intent in = new Intent(PostsActivity.this, CreatePostActivity.class);
                startActivity(in);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }


    protected void replaceContentLayout(int sourceId, int destinationId){
        View contentLayout = findViewById(destinationId);

        ViewGroup parent = (ViewGroup) contentLayout.getParent();
        int index = parent.indexOfChild(contentLayout);

        parent.removeView(contentLayout);
        contentLayout = getLayoutInflater().inflate(sourceId, parent, false);
        parent.addView(contentLayout, index);
    }

    @Override
    public void onClick(int position) {
        Content selectedPost = pAdapter.getSelectedPost(position);
        Intent intent = new Intent(PostsActivity.this, ReadPostActivity.class);
        intent.putExtra("id", selectedPost.getId());
        startActivity(intent);


    }



    private void configViews() {
        recyclerView = this.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        pAdapter = new PostListViewAdapter(this);
        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(pLayoutManager);


        recyclerView.setAdapter(pAdapter);
    }







}

