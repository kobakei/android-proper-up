package io.github.kobakei.properup.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import io.github.kobakei.properup.R;
import io.github.kobakei.properup.entity.Post;
import io.github.kobakei.properup.fragment.PostFragment;

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
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostClicked(Post item) {
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("user", item.user.name);
        intent.putExtra("content", item.content);
        startActivity(intent);
    }

    @Override
    public void onUserClicked(Post post) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("user", post.user.name);
        startActivity(intent);
    }
}
