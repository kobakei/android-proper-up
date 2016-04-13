package io.github.kobakei.properup.util;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;

/**
 * Created by keisuke on 16/04/14.
 */
public class NavUtils2 {
    /**
     * 万能なUpボタンの実装
     * @param sourceActivity
     */
    public static void navigateUp(@NonNull Activity sourceActivity) {
        Intent upIntent = NavUtils.getParentActivityIntent(sourceActivity);
        if (NavUtils.shouldUpRecreateTask(sourceActivity, upIntent)) {
            TaskStackBuilder.create(sourceActivity)
                    .addNextIntentWithParentStack(upIntent)
                    .startActivities();
        } else {
            NavUtils.navigateUpTo(sourceActivity, upIntent);
        }
    }
}
