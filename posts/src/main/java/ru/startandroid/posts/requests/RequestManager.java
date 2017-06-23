package ru.startandroid.posts.requests;

import com.squareup.okhttp.OkHttpClient;


import java.util.Collections;
import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import ru.startandroid.posts.Post.Post;

/**
 * Created by Slav on 15.11.2016.
 */

public class RequestManager {

    private static final RequestManager INSTANCE = new RequestManager();
    public static final String API_BASE_URL = "http://jsonplaceholder.typicode.com";

    private Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public <S> S createService(Class<S> serviceClass) {
        retrofit.Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    private final PostReqests postReqests = createService(PostReqests.class);

    public static RequestManager getInstance() {
        return INSTANCE;
    }

    public void loadPosts(final Callback<List<Post>> callback) {
        postReqests.getPosts().enqueue(new retrofit.Callback<List<Post>>() {
            @Override
            public void onResponse(Response<List<Post>> response, Retrofit retrofit) {
                callback.onDataLoaded(response.body());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public void loadPost(int postId, final Callback<Post> callback) {
        postReqests.getPost(postId).enqueue(new retrofit.Callback<Post>() {
            @Override
            public void onResponse(Response<Post> response, Retrofit retrofit) {
                callback.onDataLoaded(response.body());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public interface Callback<T> {
        void onDataLoaded(T result);
    }
}