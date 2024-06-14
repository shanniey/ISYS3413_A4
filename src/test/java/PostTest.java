import org.example.Post;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostTest {

    @Test
    public void testAddPost_validTitleLength() {
        String title = "This is a valid title ";
        String body = "In today's test , fast-paced tag  world,  tag2 it's crucial to take a moment to reflect on the small joys and simple pleasures that make life meaningful. Whether it's the warmth of a morning cup of coffee, the smile of a loved one, or the beauty of a sunset, these moments remind us of the richness of life. Embracing gratitude can transform our outlook, helping us navigate challenges with resilience and grace. Let's make a conscious effort to appreciate the present, cherish our relationships, and find contentment in the everyday. By doing so, we cultivate a deeper sense of happiness and fulfillment.";
        String tags = "test tag tag2";
        String type = "easy";
        String emergency = "ordinary";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        comments.add("comment one to test for this");
        comments.add("comment two to test for  this");

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns true and state remains true
        assertTrue(added);
        assertTrue(post.state);
    }

    @Test
    public void testAddPost_titleTooShort() {
        String title = "Short";
        String body = "Some content for the post";
        String tags = "test,tag";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_titleTooLong() {
        String veryLongTitle = "This is a very long title that exceeds the 250 character limit. It is much longer than a typical title should be and will trigger the validation to fail.";
        String body = "Some content for the post";
        String tags = "test,tag";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(veryLongTitle, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_bodyTooShort() {
        String title = "Valid title";
        String body = "Short body"; // Less than 250 characters
        String tags = "test";
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_tooFewTags() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "singleTag"; // Only one tag
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_tooManyTags() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "tag1 tag2 tag3 tag4 tag5 tag6"; // More than 5 tags
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_invalidTagLengthShort() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "tag a"; // Tag with one character
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_invalidTagLengthLong() {
        String title = "Valid title";
        String body = "Some content";
        String tags = "veryLongTagThatExceedsTheLimit"; // Tag with more than 10 characters
        String type = "article";
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }

    @Test
    public void testAddPost_difficultPost_shortBody() {
        String title = "Valid title";
        String body = "Short body"; // Less than 300 characters
        String tags = "test";
        String type = "difficult"; // Difficulty set to difficult
        String emergency = "false";
        String status = "draft";
        List<String> comments = new ArrayList<>();

        Post post = new Post(title, body, tags, type, emergency, status, comments);

        boolean added = post.addPost();

        // Assert that the method returns false and state is set to false
        assertFalse(added);
        assertFalse(post.state);
    }
}