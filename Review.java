package org.example;

import java.util.ArrayList;

public class Review extends Rating {
    private String text;
    private boolean spoiler;
    private ArrayList<LikeOrDislike> likeOrDislikes;
    private int reviewNumber;


    public Review(String text, boolean spoiler,Rate rate, Member rator, Movie rateShode) {
        super(rate,rator,rateShode);
        this.text = text;
        this.spoiler = spoiler;
        this.likeOrDislikes = new ArrayList<LikeOrDislike>();

    }


    public void setLikeOrDislikes(ArrayList<LikeOrDislike> likeOrDislikes) {
        this.likeOrDislikes = likeOrDislikes;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setReviewNumber(int reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public boolean isSpoiler() {
        return this.spoiler;
    }

    public String getText() {
        return this.text;
    }

    public ArrayList<LikeOrDislike> getLikeOrDislikes() {
        return this.likeOrDislikes;
    }

    public int getReviewNumber() {
        return this.reviewNumber;
    }
}
