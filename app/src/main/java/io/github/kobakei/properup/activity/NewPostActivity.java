package io.github.kobakei.properup.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.kobakei.properup.R;

/**
 * 投稿画面
 * この画面は他のアプリから暗黙的インテントで直接呼び出されることがある
 */
public class NewPostActivity extends AppCompatActivity {

    private static final String TAG = NewPostActivity.class.getSimpleName();

    @Bind(R.id.edit)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_edit);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 外部アプリから呼ばれたときの処理
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (action != null && action.equals(Intent.ACTION_SEND) && type != null) {
            if (type.equals("text/plain")) {
                editText.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.v(TAG, "Up pressed");
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    Log.v(TAG, "Recreate task");
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                } else {
                    Log.v(TAG, "Same task");
                    NavUtils.navigateUpFromSameTask(this);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 投稿ボタンを押された時
     * 他のアプリから呼び出された時は、投稿完了後元のアプリに戻るのが正しいので、
     * finishだけする
     */
    @OnClick(R.id.button)
    void onButtonClicked() {
        Toast.makeText(this, "Completed post", Toast.LENGTH_SHORT).show();
        finish();
    }
}
