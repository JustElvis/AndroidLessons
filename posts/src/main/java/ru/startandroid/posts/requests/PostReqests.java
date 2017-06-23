package ru.startandroid.posts.requests;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import ru.startandroid.posts.Post.Post;

public interface PostReqests {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{postID}")
    Call<Post> getPost(@Path("postID") int postID);

    @POST("/posts")
    Call<Post> addPost(@Body Post post);

}