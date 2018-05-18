package com.example.hrle.android_portal;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hrle.android_portal.Adapters.PostAdapter;
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

        super.replaceContentLayout(R.layout.activity_read_post, R.id.recycler_view);





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



}
