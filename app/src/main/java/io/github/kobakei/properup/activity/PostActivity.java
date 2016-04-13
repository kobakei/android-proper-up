package io.github.kobakei.properup.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.kobakei.properup.R;

public class PostActivity extends AppCompatActivity {

    @Bind(R.id.user)
    TextView userView;
    @Bind(R.id.content)
    TextView contentView;

    private String user;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = getIntent().getStringExtra("user");
        content = getIntent().getStringExtra("content");

        userView.setText(user);
        contentView.setText(content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.user)
    void onUserClicked() {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
