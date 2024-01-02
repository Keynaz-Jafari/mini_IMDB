package org.example;

import java.util.ArrayList;

public class ForumDB {

    private static ArrayList<Forum> forums=new ArrayList<>(); // database of forums of different topics


    public static void setForums(ArrayList<Forum> Forums) {
        forums = Forums;
    }
    public static ArrayList<Forum> getForums() {
        return forums;
    }

}
