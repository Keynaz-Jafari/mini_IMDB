package org.example;

import java.util.Date;

public class Report {
    private String text;
    private String title;
    private Date date;

    public Report(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return this.date;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }
}
