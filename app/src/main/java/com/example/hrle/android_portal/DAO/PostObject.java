package com.example.hrle.android_portal.DAO;

import android.location.Location;

import com.example.hrle.android_portal.model.Comment;
import com.example.hrle.android_portal.model.Post;
import com.example.hrle.android_portal.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostObject implements PostRepository {

    private static PostObject instance;

    public static PostObject getInstance(){
        if(instance == null){
            instance = new PostObject();
        }
        return instance;
    }

    @Override
    public Post getPostById(int id) {
        Post createPost = new Post();
        createPost.setId(0);
        createPost.setTitle("Treci svetski rat");
        createPost.setDate(new Date());
        createPost.setDescription("Srbija izlazi iz rata kao pobednik po prvi put");
        createPost.setLikes(82);
        createPost.setDislikes(2);

        Location location = new Location("NS");
        location.setLatitude(45.2671352);
        location.setLongitude(19.8335496);
        createPost.setLocation(location);

        User user = new User();
        user.setId(0);
        user.setName("Radovan");
        user.setUsername("Rasko");
        createPost.setAuthor(user);

        Comment comment1 = new Comment();
        comment1.setAuthor(user);
        comment1.setDate(new Date());
        comment1.setDescription("Vraticemo sve sto je nase");
        comment1.setDislikes(1);
        comment1.setLikes(36);
        comment1.setPost(createPost);
        comment1.setTitle("Samo napred");

        Comment comment2 = new Comment();
        comment2.setAuthor(user);
        comment2.setDate(new Date());
        comment2.setDescription("Povratili smo Makedoniju");
        comment2.setDislikes(0);
        comment2.setLikes(42);
        comment2.setPost(createPost);
        comment2.setTitle("Prvi korak");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        createPost.setComments(comments);

        return createPost;
    }
}
