package org.example;

public class Comment implements ReportReceiver {
    public void reportReceived() {
    }
    private String text;
    private Member sender;
    private Comment replyToWhat;

    public Comment(String text, Member sender, Comment replyToWhat) {
        this.text = text;
        this.sender = sender;
        this.replyToWhat = replyToWhat;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setReplyToWhat(Comment replyToWhat) {
        this.replyToWhat = replyToWhat;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    public String getText() {
        return this.text;
    }


    public Member getSender() {
        return this.sender;
    }


    public Comment getReplyToWhat() {
        return this.replyToWhat;
    }

}

