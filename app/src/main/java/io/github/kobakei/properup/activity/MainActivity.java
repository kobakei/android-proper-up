package io.github.kobakei.properup.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import io.github.kobakei.properup.R;
import io.github.kobakei.properup.entity.Post;
import io.github.kobakei.properup.fragment.PostFragment;

/**
 * タイムライン画面
 */
public class MainActivity extends AppCompatActivity implements PostFragment.OnListFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                goToSearch();
                return true;
            case R.id.post:
                goToNewPost();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostClicked(Post post) {
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("image", post.user.face);
        intent.putExtra("user", post.user.name);
        intent.putExtra("content", post.content);
        startActivity(intent);
    }

    @Override
    public void onUserClicked(Post post) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("user", post.user.name);
        intent.putExtra("image", post.user.face);
        startActivity(intent);
    }

    private void goToSearch() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    private void goToNewPost() {
        Intent intent = new Intent(this, NewPostActivity.class);
        startActivity(intent);
    }
}
