package org.example;

import java.sql.Timestamp;

public class Notification {
    private Content content;
    private String title;
    private Timestamp sent;
    private Sender sender;


    public void setSender(Sender sender) {
        this.sender = sender;
    }
    public void setContent(Content content) {
        this.content = content;
    }

    public void setSent(Timestamp sent) {
        this.sent = sent;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getSent() {
        return this.sent;
    }
    public Sender getSender() {
        return this.sender;
    }
    public Content getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }


}
