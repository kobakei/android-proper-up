package io.github.kobakei.properup.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keisuke on 16/04/13.
 */
public class Post {
    public String content;
    public User user;

    public Post(User user, String content) {
        this.content = content;
        this.user = user;
    }

    public static List<Post> ITEMS = new ArrayList<Post>() {{
        add(new Post(User.ITEM1, "Hello 1"));
        add(new Post(User.ITEM2, "Hello 2"));
        add(new Post(User.ITEM3, "Hello 3"));
        add(new Post(User.ITEM1, "Hello 4"));
        add(new Post(User.ITEM2, "Hello 5"));
        add(new Post(User.ITEM3, "Hello 6"));
        add(new Post(User.ITEM1, "Hello 7"));
        add(new Post(User.ITEM2, "Hello 8"));
        add(new Post(User.ITEM3, "Hello 9"));
        add(new Post(User.ITEM1, "Hello 10"));
        add(new Post(User.ITEM1, "Hello 11"));
        add(new Post(User.ITEM2, "Hello 12"));
        add(new Post(User.ITEM3, "Hello 13"));
        add(new Post(User.ITEM1, "Hello 14"));
        add(new Post(User.ITEM2, "Hello 15"));
        add(new Post(User.ITEM3, "Hello 16"));
        add(new Post(User.ITEM1, "Hello 17"));
        add(new Post(User.ITEM2, "Hello 18"));
        add(new Post(User.ITEM3, "Hello 19"));
    }};
}
