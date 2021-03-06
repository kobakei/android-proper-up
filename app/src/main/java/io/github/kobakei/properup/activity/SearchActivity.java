package io.github.kobakei.properup.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import io.github.kobakei.properup.R;
import io.github.kobakei.properup.entity.Post;
import io.github.kobakei.properup.fragment.PostFragment;

/**
 * 検索結果画面
 */
public class SearchActivity extends AppCompatActivity implements PostFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                overridePendingTransition(R.animator.pull_in_left, R.animator.push_out_right);
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
}
