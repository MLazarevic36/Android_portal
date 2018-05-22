package com.example.hrle.android_portal.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import com.example.hrle.android_portal.Fragments.ReadPostFragment;
import com.example.hrle.android_portal.PostsActivity;
import com.example.hrle.android_portal.R;
import com.example.hrle.android_portal.ReadPostActivity;
import com.example.hrle.android_portal.model.Post;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


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

    public Post getSelectedPost(int position) {
            return posts.get(position);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
            public TextView title, description, slika;

            public CustomViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.naslov_posta);
                description = view.findViewById(R.id.opis_posta);
                slika = view.findViewById(R.id.slika_posta);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       Intent intent = new Intent (v.getContext(), ReadPostActivity.class);
                       intent.putExtra("id", getSelectedPost(getLayoutPosition()).getId());
                       intent.putExtra("title", getSelectedPost(getLayoutPosition()).getTitle());
                       intent.putExtra("description", getSelectedPost(getLayoutPosition()).getDescription());
                       intent.putExtra("photo", getSelectedPost(getLayoutPosition()).getPhoto());
                       intent.putExtra("user", getSelectedPost(getLayoutPosition()).getUser().toString());
                       intent.putExtra("date", getSelectedPost(getLayoutPosition()).getDate());
                       intent.putExtra("location", getSelectedPost(getLayoutPosition()).getLocation());
                       intent.putExtra("tags", getSelectedPost(getLayoutPosition()).getTags());
                       intent.putExtra("likes", getSelectedPost(getLayoutPosition()).getLikes().toString());
                       intent.putExtra("dislikes", getSelectedPost(getLayoutPosition()).getDislikes().toString());
                       //intent.putExtra("comments", getSelectedPost(0).getComments().toArray());

                       v.getContext().startActivity(intent);


//                       Bundle bundle = new Bundle();
//                       bundle.putSerializable("id", getSelectedPost(getLayoutPosition()).getId());
//                       bundle.putSerializable("title", getSelectedPost(getLayoutPosition()).getTitle());
//                       bundle.putSerializable("description", getSelectedPost(getLayoutPosition()).getDescription());
//                       bundle.putSerializable("photo", getSelectedPost(getLayoutPosition()).getPhoto());
//                       bundle.putSerializable("user", getSelectedPost(getLayoutPosition()).getUser().toString());
















                    }



                }



                );
            }






    }
}

