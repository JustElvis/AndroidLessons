package ru.startandroid.posts.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import ru.startandroid.posts.Post.Post;
import ru.startandroid.posts.R;
import ru.startandroid.posts.requests.RequestManager;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Post> mPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.posts_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPostDetails(mPosts.get(position));
            }
        });

        loadPosts();
    }

    private void showPostDetails(Post post) {
        Intent intent = new Intent(this, PostDetailsActivity.class);
        intent.putExtra(PostDetailsActivity.EXTRA_POST_ID, post.getId());

        startActivity(intent);
    }

    private void loadPosts() {
        RequestManager.getInstance().loadPosts(new RequestManager.Callback<List<Post>>() {

            @Override
            public void onDataLoaded(List<Post> result) {
                showPosts(result);
            }
        });
    }

    private void showPosts(List<Post> result) {
        mPosts = new ArrayList<>(result);
        ArrayAdapter<Post> adapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, mPosts) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView)view.findViewById(android.R.id.text1)).setText(getItem(position).getTitle());
                return view;
            }
        };
        listView.setAdapter(adapter);
    }

}
