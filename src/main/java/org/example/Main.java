package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String title = "This is a valid title ";
        String body = "In today's test , fast-paced tag  world,  tag2 it's crucial to take a moment to reflect on the small joys and simple pleasures that make life meaningful. Whether it's the warmth of a morning cup of coffee, the smile of a loved one, or the beauty of a sunset, these moments remind us of the richness of life. Embracing gratitude can transform our outlook, helping us navigate challenges with resilience and grace. Let's make a conscious effort to appreciate the present, cherish our relationships, and find contentment in the everyday. By doing so, we cultivate a deeper sense of happiness and fulfillment.";
        String tags = "test tag tag2";
        String type = "easy";
        String emergency = "ordinary";
        String status = "draft";
        List<String> comments = new ArrayList<>();
        comments.add("Comment one to test for this");
        comments.add("Comment two to test for  this");

        Post post = new Post(title, body, tags, type, emergency, status, comments);
System.out.println(post.addPost());
        System.out.println(post.addComment());
        if(post.addPost() && post.addComment()){
            String filePath = "output.txt";

            // Create a FileWriter object
            FileWriter writer = null;
            try {
                writer = new FileWriter(filePath);
                // Write the text to the file
                writer.write(title+ body+ tags+"comments"+String.join(", ", comments));
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {

                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            } finally {

                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {

                    System.out.println("An error occurred while closing the file.");
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("post returned false.");
        }

        }



    }
