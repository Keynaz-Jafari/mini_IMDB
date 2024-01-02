package org.example;

import javax.management.relation.Role;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Movie implements ReportReceiver {
    @Override
    public void reportReceived() {
    }

    private String Title;
    private String PlotSummary;
    private File[] posters;
    private File[] trailers;
    private String genre;
    private LocalDate release;
    private String language;
    private ArrayList<Movie> suggestByGenre;
    private ArrayList<Movie> suggestByDirector;
    private ArrayList<Movie> suggestByWriter;
    private ArrayList<RoleInMovie> rolesInMovie;
    private ArrayList<Review> reviews; // momkene redundant bashe
    private ArrayList<Rating> ratings;
    private ArrayList<Goof> goofs;
    private ArrayList<Trivia> trivias;
    private  ArrayList<SoundTrack> soundTracks;
    private ArrayList<Quote> quotes;
    private UUID uuid;

    private ArrayList<Report> reports;



    public Movie(String title, String genre, LocalDate release, String language, ArrayList<RoleInMovie> rolesInMovie){
        this.Title = title;
        this.genre = genre.toLowerCase();
        this.release = release;
        this.language = language;
        this.rolesInMovie=rolesInMovie;
        this.reviews=new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.trivias = new ArrayList<>();
        this.goofs = new ArrayList<>();
        this.soundTracks = new ArrayList<>();
        this.quotes = new ArrayList<>();
        this.uuid = UUID.randomUUID();
        this.reports=new ArrayList<>();

    }

    public void WriteReview(String text, boolean spoiler,Rate rate, Member rator, Movie rateShode){
        for(Review review: reviews){
            if(review.getRator()==rator){
                System.out.println("already reviewed!");
                return;
            }
        }
        Review review = new Review(text,spoiler,rate,rator,rateShode);
    }


    public void showMovieInfo(Movie movie){
        System.out.println("name: "+movie.getTitle());
        System.out.println("genre: " +movie.getGenre());
        System.out.println("language: "+movie.getLanguage());
        for(RoleInMovie role:movie.getRolesInMovie()){
            if(role.getMovieRole().equals(MovieRole.DIRECTOR)){
                System.out.println("direcotr: "+role.getPerson().getName()+" "+role.getPerson().getLastName());
            }
            else if(role.getMovieRole().equals(MovieRole.WRITER)){
                System.out.println("written by: "+role.getPerson().getName()+" "+role.getPerson().getLastName());
            }
            else if(role.getMovieRole().equals(MovieRole.ACTOR)){
                System.out.println("Actors: "+role.getPerson().getName()+" "+role.getPerson().getLastName());
            }
        }
    }


    public void addWriter(Person writer){
        RoleInMovie actorRole = new RoleInMovie(MovieRole.WRITER,writer);
        this.rolesInMovie.add(actorRole);
    }

    public void addDirector(Person director){
        RoleInMovie actorRole = new RoleInMovie(MovieRole.DIRECTOR,director);
        this.rolesInMovie.add(actorRole);
    }

    public void addActor(Person acotr){
        RoleInMovie actorRole = new RoleInMovie(MovieRole.ACTOR,acotr);
        this.rolesInMovie.add(actorRole);
    }

    public void displayReviews() {
        ArrayList<Review> reviews = this.getReviews();
        for (int i = 0; i < reviews.size(); i++) {
            Review review = reviews.get(i);
            System.out.println((i + 1) + ". " + review.getText() + " - Spoiler: " + review.isSpoiler());
        }
    }

    public void deleteReview(int reviewNumber) {
        ArrayList<Review> reviews = this.getReviews();
        if (reviewNumber > 0 && reviewNumber <= reviews.size()) {
            // Remove the review based on its number (subtract 1 for index)
            reviews.remove(reviewNumber - 1);
            System.out.println("Review number " + reviewNumber + " has been deleted.");
        } else {
            System.out.println("Invalid review number.");
        }
    }



    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setRolesInMovie(ArrayList<RoleInMovie> rolesInMovie) {
        this.rolesInMovie = rolesInMovie;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setSuggestByWriter(ArrayList<Movie> suggestByWriter) {
        this.suggestByWriter = suggestByWriter;
    }


    public void setPlotSummary(String plotSummary) {
        PlotSummary = plotSummary;
    }

    public void setSuggestByDirector(ArrayList<Movie> suggestByDirector) {
        this.suggestByDirector = suggestByDirector;
    }

    public void setPosters(File[] posters) {
        this.posters = posters;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTrailers(File[] trailers) {
        this.trailers = trailers;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getGenre() {
        return genre.toLowerCase();
    }



    public void setSuggestByGenre(ArrayList<Movie> suggestByGenre) {
        this.suggestByGenre = suggestByGenre;
    }
    public void setGenre(String genre) {
        this.genre = genre.toLowerCase();
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setGoofs(ArrayList<Goof> goofs) {
        this.goofs = goofs;
    }

    public void setTrivias(ArrayList<Trivia> trivias) {
        this.trivias = trivias;
    }

    public void setSoundTracks(ArrayList<SoundTrack> soundTracks) {
        this.soundTracks = soundTracks;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }

    public LocalDate getRelease() {
        return this.release;
    }

    public String getLanguage() {
        return this.language;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public ArrayList<Movie> getSuggestByGenre() {
        return this.suggestByGenre;
    }

    public ArrayList<Movie> getSuggestByDirector() {
        return this.suggestByDirector;
    }

    public ArrayList<Movie> getSuggestByWriter() {
        return this.suggestByWriter;
    }

    public ArrayList<RoleInMovie> getRolesInMovie() {
        return this.rolesInMovie;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getPlotSummary() {
        return this.PlotSummary;
    }

    public File[] getPosters() {
        return this.posters;
    }

    public File[] getTrailers() {
        return this.trailers;
    }

    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

    public ArrayList<Quote> getQuotes() {
        return this.quotes;
    }

    public ArrayList<Goof> getGoofs() {
        return this.goofs;
    }

    public ArrayList<Trivia> getTrivias() {
        return this.trivias;
    }

    public ArrayList<SoundTrack> getSoundTracks() {
        return this.soundTracks;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public ArrayList<Report> getReports() {
        return this.reports;
    }
}
