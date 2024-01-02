package org.example;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Rating {
    private Rate rate;
    private Member Rator;
    private Movie rateShode;
     private Timestamp dateOfRate;

    public Rating(Rate rate, Member rator, Movie rateShode) {
        this.rate = rate;
        Rator = rator;
        this.rateShode = rateShode;
        this.dateOfRate = new Timestamp(System.currentTimeMillis()); // system hamun lahze time mzre barash
    }

    public int convertToNumber(Rating rate){
        int ratingNumber=0;

         if(rate.getRate().equals(Rate.ONE)){
           ratingNumber=1;
        }
        if(rate.getRate().equals(Rate.TWO)){
            ratingNumber=2;

        }
        else if(rate.getRate().equals(Rate.THREE)){
            ratingNumber=3;

        }
        else if(rate.getRate().equals(Rate.FOUR)){
            ratingNumber=4;

        }
        else if(rate.getRate().equals(Rate.FIVE)){
            ratingNumber=5;

        }
        return ratingNumber;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }


    public void setRator(Member rator) {
        Rator = rator;
    }

    public void setDateOfRate(Timestamp dateOfRate) {
        this.dateOfRate = dateOfRate;
    }

    public void setRateShode(Movie rateShode) {
        this.rateShode = rateShode;
    }

    public Date getDateOfRate() {
        return this.dateOfRate;
    }

    public Rate getRate() {
        return this.rate;
    }

    public Member getRator() {
        return this.Rator;
    }

    public Movie getRateShode() {
        return this.rateShode;
    }
}
