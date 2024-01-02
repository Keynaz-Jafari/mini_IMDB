package org.example;

import java.util.ArrayList;

public class Forum {
    private ArrayList<Comment> comments;
    private String topic;

    public Forum( String topic) {
        this.comments = new ArrayList<Comment>();
        this.topic = topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    public String getTopic() {
        return this.topic;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }
}
