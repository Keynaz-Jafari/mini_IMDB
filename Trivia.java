package org.example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Trivia {
    private String text;
    private Date upload;
    private Member writer;

    public Trivia(String text) {
        this.text = text;
        this.upload = new Timestamp(System.currentTimeMillis());

    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUpload(Date upload) {
        this.upload = upload;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

    public String getText() {
        return this.text;
    }
    public Member getWriter() {
        return this.writer;
    }
    public Date getUpload() {
        return this.upload;
    }

}
