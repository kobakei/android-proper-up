package io.github.kobakei.properup.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.kobakei.properup.R;

/**
 * ユーザー情報画面
 */
public class UserActivity extends AppCompatActivity {

    @Bind(R.id.image)
    ImageView imageView;
    @Bind(R.id.user)
    TextView userView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        userView.setText(getIntent().getStringExtra("user"));
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
}
