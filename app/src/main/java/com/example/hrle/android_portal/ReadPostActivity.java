package com.example.hrle.android_portal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hrle.android_portal.Adapters.PostAdapter;
import com.example.hrle.android_portal.model.Comment;
import com.example.hrle.android_portal.model.Post;

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

    Toolbar toolbar;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);

        toolbar = findViewById(R.id.toolbar_rp);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



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
        Bundle b = ii.getExtras();

        if (b != null) {
            String t = getIntent().getExtras().getString("title");
            String d = getIntent().getExtras().getString("description");
            String p = getIntent().getExtras().getString("photo");
            String a = getIntent().getExtras().getString("user");
            String da = getIntent().getExtras().getString("date");
            String l = getIntent().getExtras().getString("location");
            String ta = getIntent().getExtras().getString("tags");
            String li = getIntent().getExtras().getString("likes");
            String di = getIntent().getExtras().getString("dislikes");
            //String c = getIntent().getExtras().getString("comments");
            title.setText(t);
            slika.setText(p);
            description.setText(d);
            author.setText(a);
            date.setText(da);
            location.setText(l);
            likes.setText(li);
            dislikes.setText(di);



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
        inflater.inflate(R.menu.toolbar_settings_rp, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
