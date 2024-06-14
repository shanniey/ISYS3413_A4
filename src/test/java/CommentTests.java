import org.example.Post;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentTests {
    @Test
    public void testAddComment_validComment() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "test";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        comments.add("This is a valid comment with 5 words ");

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addComment();


        assertTrue(added);
        assertTrue(post.state);
    }

    @Test
    public void testAddComment_tooShortComment() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "test";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        comments.add("Short"); // Less than 4 words

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addComment();


        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddComment_tooLongComment() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "test";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        comments.add("This is a very long comment that has more than 10 words. It should trigger the validation to fail.");

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addComment();


        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddComment_notStartingWithUppercase() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "test";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        comments.add("this lowercase comment should fail");

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addComment();


        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddComment_tooManyComments_ordinaryEmergency() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "test";
        String type = "article";
        String emergency = "Ordinary";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            comments.add("Comment " + i);
        }

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addComment();


        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddComment_tooManyComments_easyType() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "test";
        String type = "easy";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            comments.add("Comment " + i);
        }

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addComment();


        assertFalse(added);
        assertFalse(post.state);
    }
}
