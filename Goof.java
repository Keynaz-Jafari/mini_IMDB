package org.example;

import java.sql.Timestamp;
import java.util.Date;

public class Goof {

    private String text;
    private Date upload;
    private Member writer;

    public Goof(String text) {
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
    public Date getUpload() {
        return this.upload;
    }

    public Member getWriter() {
        return this.writer;
    }
}
