package michael.wheaton.com.androiddemo;

/**
 * Created by michaelliu on 2/16/17.
 */

public class Post {
    public String author;
    public String title;

    public Post(String author, String title) {
        this.author = author;
        this.title = title;
    }
    public Post(){
        this.author = "";
        this.title = "";
    }
}
