package org.example;

import java.util.ArrayList;

public class MovieManage {
    private ArrayList<Movie>movies; // works like the database for the movies stored
    private static MovieManage instance;

    private MovieManage() {
        movies = new ArrayList<>();
    }


    public static MovieManage getInstance() {
        if (instance == null) {
            instance = new MovieManage();
        }
        return instance;
    }

    public void AddMovie(Movie movie){
        if(movie!=null && !movies.contains(movie)){
            movies.add(movie);
        }
    }
    public boolean DeleteMovie(Movie movie) {
        if (movie != null && movies.contains(movie)) {
            return movies.remove(movie);
        }
        return false; // movie vojood nadashte ke delete beshe
    }

    public Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }



    // hameye info haye movie ro neshoon bede

    public  ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    // to find a movie by its title

}
