package com.example.hrle.android_portal.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrle.android_portal.PostsActivity;
import com.example.hrle.android_portal.R;
import com.example.hrle.android_portal.model.Post;

import java.util.ArrayList;
import java.util.List;


public class PostListViewAdapter extends RecyclerView.Adapter<PostListViewAdapter.CustomViewHolder> {



        private List<Post> posts;

        public PostListViewAdapter(List<Post> posts) {
            this.posts = posts;
        }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

            Post post = posts.get(position);
            holder.title.setText(post.getTitle());
            holder.description.setText(post.getDescription());
            holder.slika.setText(post.getPhoto());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
            public TextView title, description, slika;

            public CustomViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.naslov_posta);
                description = view.findViewById(R.id.opis_posta);
                slika = view.findViewById(R.id.slika_posta);
            }
    }
}

