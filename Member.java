package org.example;

import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Member extends Person implements ReportReceiver{
    public void reportReceived() {
    }

    private AccessLevel accessLevel;

    private ContactPoint contactPoint;
    private File picture;
    private String username;
    private String password;
    private Date dateOfBirth;
    private Geoloc address;
    private ArrayList<Movie> watchlist;
    private ArrayList<Movie> favorites;
    private ArrayList<Movie> recommended;
   private ArrayList<Person> followings;
    private ArrayList<Notification> notifications;
    private ArrayList<Report> reports;
    private ArrayList<Movie>  chart;
    private String email;
    private ArrayList<GroupChat> groupChats;

    public Member(String username, String password, String email,String name,String lastName, AccessLevel accessLevel) {
        super(name,lastName);
        this.username = username;
        this.password= password; // baadan hash kon
        this.email = email;
        this.accessLevel=AccessLevel.MEMBER;
        this.favorites = new ArrayList<>();
        this.watchlist = new ArrayList<>();
        this.followings = new ArrayList<>();
        this.groupChats=new ArrayList<>();


    }

    public Member(String username, String password, String email,String name,String lastName) {
        super(name,lastName);
        this.username = username;
        this.password= password; // baadan hash kon
        this.email = email;
    }

    public ArrayList<Movie> createSuggestions(Member member){ // mire tooye favorite haye taraf genre max ro entekhab va suggestion misaze az oon genre
        //int count = 5; // max 5 ta suggest bede
        int maxKey = Integer.MIN_VALUE;
        String maxValue = null;
        HashMap<String,Integer> favoriteHashmap = new HashMap<String,Integer>();
        ArrayList<String> maxValues = new ArrayList<>();
        ArrayList<Movie> suggestions = new ArrayList<>();

        for (Movie favoriteMovie: member.getFavorites()){
            if(favoriteHashmap.containsKey(favoriteMovie.getGenre().toLowerCase())){
                favoriteHashmap.replace(favoriteMovie.getGenre().toLowerCase(),favoriteHashmap.get(favoriteMovie.getGenre().toLowerCase())+1);
            }
            else{
                favoriteHashmap.put(favoriteMovie.getGenre().toLowerCase(),1);
            }
        }
        // begarde too map bebine genre haye max chie

        for(Map.Entry<String,Integer> entry:favoriteHashmap.entrySet()){
            if(entry.getValue()>=maxKey){
                maxValue = entry.getKey();
                maxKey = entry.getValue();
                maxValues.add(maxValue);
            }
        }
        if(maxValues.isEmpty()){
            System.out.println("you have no favorites to have a suggestion list");
        }
        else { // sakhtane suggestion arraylist
            for (String max: maxValues){
                for(Movie suggestionMovie:MovieManage.getInstance().getMovies()){
                    if(suggestionMovie.getGenre().equalsIgnoreCase(max)){
                        suggestions.add(suggestionMovie);
                    }
                }
            }
        }
        return suggestions;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setContactPoint(ContactPoint contactPoint) {
        this.contactPoint = contactPoint;
    }

    public void setChart(ArrayList<Movie> chart) {
        this.chart = chart;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFollowings(ArrayList<Person> followings) {
        this.followings = followings;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRecommended(ArrayList<Movie> recommended) {
        this.recommended = recommended;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setAddress(Geoloc address) {
        this.address = address;
    }

    public void setWatchlist(ArrayList<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    public void setFavorites(ArrayList<Movie> favorites) {
        this.favorites = favorites;
    }

    public void setGroupChats(ArrayList<GroupChat> groupChats) {
        this.groupChats = groupChats;
    }

    public ArrayList<Movie> getFavorites() {
        return this.favorites;
    }
    public String getEmail() {
        return this.email;
    }
    public ArrayList<Movie> getRecommended() {
        return this.recommended;
    }

    public ArrayList<Person> getFollowings() {
        return this.followings;
    }

    public ArrayList<Notification> getNotifications() {
        return this.notifications;
    }

    public ArrayList<Report> getReports() {
        return this.reports;
    }

    public ArrayList<Movie> getChart() {
        return this.chart;
    }

    public ContactPoint getContactPoint() {
        return this.contactPoint;
    }

    public File getPicture() {
        return this.picture;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword()  {
        return (this.password);
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Geoloc getAddress() {
        return this.address;
    }


    public ArrayList<Movie> getWatchlist() {
        return this.watchlist;
    }

    public ArrayList<GroupChat> getGroupChats() {
        return this.groupChats;
    }

    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }
}
