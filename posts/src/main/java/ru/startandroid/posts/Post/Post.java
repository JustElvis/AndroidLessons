package ru.startandroid.posts.Post;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Slav on 15.11.2016.
 */
public class Post {

    @SerializedName("id")
    private int postID;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public Post(){}

    public Post (String title, String body){
        this.body = body;
        this.title = title;
    }
    public int getId() {
        return postID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
