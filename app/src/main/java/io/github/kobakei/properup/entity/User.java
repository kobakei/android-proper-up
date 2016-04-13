package io.github.kobakei.properup.entity;

import android.support.annotation.DrawableRes;

import io.github.kobakei.properup.R;

/**
 * Created by keisuke on 16/04/13.
 */
public class User {
    public String name;
    @DrawableRes
    public int face;

    public User(String name, int face) {
        this.name = name;
        this.face = face;
    }

    public static User ITEM1 = new User("Jack", R.drawable.jack);
    public static User ITEM2 = new User("Chloe", R.drawable.chloe);
    public static User ITEM3 = new User("Tony", R.drawable.tony);
}
