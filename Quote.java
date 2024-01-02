package org.example;

import java.sql.Timestamp;
import java.util.Date;

public class Quote {
    private String text;
    private Date upload;
    private Member writer;

    public Quote(String text) {
        this.text = text;
        this.upload = new Timestamp(System.currentTimeMillis());
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

    public void setUpload(Date upload) {
        this.upload = upload;
    }

    public Date getUpload() {
        return this.upload;
    }
    public Member getWriter() {
        return this.writer;
    }

    public String getText() {
        return this.text;
    }
}
