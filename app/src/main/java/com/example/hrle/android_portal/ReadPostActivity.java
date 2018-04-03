package com.example.hrle.android_portal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class ReadPostActivity extends PostsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_read_post);

        FrameLayout contentFrameLayout = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_read_post, contentFrameLayout);

        super.replaceContentLayout(R.layout.activity_read_post, R.id.listView);

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
