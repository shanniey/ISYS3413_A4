package org.example;

import java.util.ArrayList;
import java.util.List;

public class Post {

    String title;
    String body;
    String tags;
    String type;
    String emergency;
    String status;
   public boolean state = true;

    List<String> comments = new ArrayList<>();

    public Post(String title, String body, String tags, String type, String emergency, String status, List<String> comments) {
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.type = type;
        this.status = status;
        this.emergency = emergency;
        this.comments = comments;
    }

    public boolean addPost() {


        //condition 1

        if (title.length() < 10 || title.length() > 250) {


            String firstFive = title.substring(0, 5);


            String regex = "^[a-zA-Z]{5}$";
            state = !firstFive.matches(regex);

            return state;


        }

        //condition2

        if (body.length() < 250) {
            state = false;

            return state;
        }
//        //condition 3
//
        String[] tagList = tags.split("\\s+");


        if (tagList.length < 2 || tagList.length > 5) {
            state = false;
            return state;
        }


        for (String tag : tagList) {
            if (tag.length() < 2 || tag.length() > 10) {
                state = false;
                return state;
            }
        }
//
//
//        //conditon 4
//
        if (type.equalsIgnoreCase("very difficult") || type.equalsIgnoreCase("difficult")) {
            if (body.length() < 300) {
                state = false;
            }
            return state;
        }
        String[] words = body.split("\\s+");
        int tagCount = 0;
        for (String tag : tagList) {
            for (String word : words) {
                if (tag.equals(word)) {
                    tagCount++;
                    break;
                }
            }
        }
        if (type.equalsIgnoreCase("easy") && tagCount > 3) {
            state = false;
            return state;
        }
//
//        //conditin 5
//
        if (emergency.equals("Immediately Needed") || emergency.equals("Highly Needed") || emergency.equalsIgnoreCase("Ordinary")) {
            if (type.equalsIgnoreCase("Easy") && (emergency.equals("Immediately Needed") || emergency.equals("Highly Needed"))) {
                state = false;
                return state;
            }

            if ((type.equalsIgnoreCase("very difficult") || type.equalsIgnoreCase("difficult")) && emergency.equals("Ordinary")) {
                state = false;
                return state;
            }
        } else {
            state = false;
            return state;
        }

        return state;

    }

    public boolean addComment() {

        //condition one
        for (String comment : comments) {
            String[] words = comment.split("\\s+");

            if (words.length > 10 || words.length < 4) {
                state = false;
                return state;
            }

            char first = words[0].charAt(0);
            if (!Character.isUpperCase(first)
            ) {
                state = false;
                return state;
            }
        }

        //condition two

        if (comments.size() > 3 && (emergency.equals("Ordinary") || type.equalsIgnoreCase("Easy"))) {
            state = false;
            return state;
        }


        return state;
    }
}
