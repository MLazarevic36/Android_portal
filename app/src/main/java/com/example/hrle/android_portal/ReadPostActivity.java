package com.example.hrle.android_portal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hrle.android_portal.Adapters.PostAdapter;
import com.example.hrle.android_portal.DAO.DateUtil;
import com.example.hrle.android_portal.DAO.PostObject;
import com.example.hrle.android_portal.model.Comment;
import com.example.hrle.android_portal.model.Post;

public class ReadPostActivity extends PostsActivity {

    private TextView title;
    private TextView author;
    private TextView date;
    private TextView location;
    private TextView likes;
    private TextView dislikes;
    private TextView description;
    private ListView listViewComments;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_read_post);

        FrameLayout contentFrameLayout = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_read_post, contentFrameLayout);

        super.replaceContentLayout(R.layout.activity_read_post, R.id.listView);

        PostObject.getInstance().getPostById(0);

        initView();
        populateView();

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

    //@Override
    //public void onBackPressed(){
        //super.onBackPressed();
    //}

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        //int id = item.getItemId();
        //if (id == android.R.id.home) {
            //onBackPressed();
            //return true;
        //}
        //return super.onOptionsItemSelected(item);
    //}


    private void initView(){
        title = findViewById(R.id.naslov);
        author = findViewById(R.id.autor);
        date = findViewById(R.id.datum);
        location = findViewById(R.id.lokacija);
        likes = findViewById(R.id.likes);
        dislikes = findViewById(R.id.dislikes);
        description = findViewById(R.id.opis);
        listViewComments = findViewById(R.id.lv_comments);
    }

    private void populateView(){
        Post post = PostObject.getInstance().getPostById(0);
        title.setText(String.format("%s %s", title.getText(), post.getTitle()));
        author.setText(String.format("%s %s", author.getText(), post.getAuthor().getName()));
        date.setText(DateUtil.convertDateToString(post.getDate()));
        location.setText(post.getLocation().toString());
        likes.setText(""+post.getLikes());
        dislikes.setText(""+post.getDislikes());
        description.setText(post.getDescription());

        Comment[] comments = new Comment[2];
        comments[0] = post.getComments().get(0);
        comments[1] = post.getComments().get(1);
        PostAdapter postAdapter = new PostAdapter(this, comments);

        listViewComments.setAdapter(postAdapter);
    }
}
