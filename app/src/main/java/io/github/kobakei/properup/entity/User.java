package io.github.kobakei.properup.entity;

/**
 * Created by keisuke on 16/04/13.
 */
public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    public static User ITEM1 = new User("Jack");
    public static User ITEM2 = new User("Chloe");
    public static User ITEM3 = new User("Tony");
}
