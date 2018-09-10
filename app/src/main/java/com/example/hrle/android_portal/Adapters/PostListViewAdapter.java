package com.example.hrle.android_portal.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.hrle.android_portal.R;
import com.example.hrle.android_portal.model.Content;
import com.example.hrle.android_portal.model.Example;
import com.example.hrle.android_portal.model.Post;
import com.example.hrle.android_portal.model.PostResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PostListViewAdapter extends RecyclerView.Adapter<PostListViewAdapter.CustomViewHolder> {


        private String zaPicasso = "http://192.168.0.18:8080/api/downloadFile/";
        private final PostClickListener mListener;
        private List<Content> posts ;


        public PostListViewAdapter(PostClickListener listener) {
            posts = new ArrayList<>();
            mListener = listener;
        }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {



            Content content = posts.get(position);
            holder.title.setText(content.getTitle());
            holder.description.setText(content.getDesc());

            Picasso.get().load(zaPicasso + content.getPhoto()).into(holder.slika);


    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    public Content getSelectedPost(int position) {
            return posts.get(position);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView title, description;
            public ImageView slika;

            public CustomViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.naslov_posta);
                description = view.findViewById(R.id.opis_posta);
                slika = view.findViewById(R.id.slika_posta);
                view.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                mListener.onClick(getLayoutPosition());
            }

    }

    public interface PostClickListener {
            void onClick(int position);
    }

    public void addPost(Content content) {
            posts.add(content);
            notifyDataSetChanged();
    }
}

