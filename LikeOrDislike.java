package org.example;

import java.util.Date;

public class LikeOrDislike {
    private boolean LikeOrNo;
    private Date date;
    private Member rator;


    public LikeOrDislike(boolean likeOrNo) {
        LikeOrNo = likeOrNo;
    }

    public void setRator(Member rator) {
        this.rator = rator;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLikeOrNo(boolean likeOrNo) {
        LikeOrNo = likeOrNo;
    }
    public boolean isLikeOrNo() {
        return this.LikeOrNo;
    }

    public Date getDate() {
        return this.date;
    }

    public Member getRator() {
        return this.rator;
    }
}
