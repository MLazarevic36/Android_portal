package com.example.hrle.android_portal.Adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hrle.android_portal.R;
import com.example.hrle.android_portal.model.Comment;
import com.example.hrle.android_portal.model.CommentResponse;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CustomViewHolderC> {

    private List<CommentResponse> comments;

    private String valuelikes, valuesdislikes;

    public CommentAdapter() {
        comments = new ArrayList<>();
    }


    @Override
    public CustomViewHolderC onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);

        return new CustomViewHolderC(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolderC holder, int position) {

        CommentResponse commentResponse = comments.get(position);
        holder.comment_naslov.setText(commentResponse.getTitle());
        holder.comment_opis.setText(commentResponse.getDesc());
        valuelikes = Integer.toString(commentResponse.getLikes());
        holder.comment_like.setText(valuelikes);
        valuesdislikes = Integer.toString(commentResponse.getDislikes());
        holder.comment_dislike.setText(valuesdislikes);


    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CustomViewHolderC extends RecyclerView.ViewHolder {

        public TextView comment_naslov, comment_opis, comment_autor, comment_like, comment_dislike;

        public CustomViewHolderC (View view) {
            super(view);
            comment_naslov = view.findViewById(R.id.comment_title);
            comment_opis = view.findViewById(R.id.comment_description);
            comment_autor = view.findViewById(R.id.comment_autor);
            comment_like = view.findViewById(R.id.comment_like);
            comment_dislike = view.findViewById(R.id.comment_dislike);

        }
    }

    public void addComment(CommentResponse commentResponse) {
        comments.add(commentResponse);
        notifyDataSetChanged();
    }
}
