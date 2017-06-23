package ru.startandroid.posts.activity;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

import ru.startandroid.posts.Post.Post;
import ru.startandroid.posts.R;
import ru.startandroid.posts.requests.RequestManager;

public class PostDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_POST_ID = "postId";
    private TextView title, body;
    private int mCurrentPostId;
    private Post mPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        title = (TextView) findViewById(R.id.title);
        body = (TextView) findViewById(R.id.body);
        mCurrentPostId = getIntent().getIntExtra(EXTRA_POST_ID, 0);
        loadPost();
    }

    private void loadPost() {
        RequestManager.getInstance().loadPost(mCurrentPostId, new RequestManager.Callback<Post>() {

            @Override
            public void onDataLoaded(Post result) {
                showPost(result);
            }
        });
    }

    private void showPost(Post result) {
        mPost = result;
        title.setText(mPost.getTitle());
        body.setText(mPost.getBody());
    }
}
