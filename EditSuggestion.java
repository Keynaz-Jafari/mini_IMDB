package org.example;

import java.util.ArrayList;

public class EditSuggestion {
    private  boolean isApproved;
    private Movie originalValue;
    private Movie suggestedValue;
    private Person originalPerson;
    private Person suggestedPerson;
    private ArrayList<Movie> movies;
    private ArrayList<Person> people;

    public EditSuggestion( Movie originalValue, Movie suggestedValue,ArrayList<Movie> movies) {
        this.isApproved = false;
        this.originalValue = originalValue;
        this.suggestedValue = suggestedValue;
        this.movies = movies;

    }

    public EditSuggestion( Person originalPerson, Person suggestedPerson, ArrayList<Person> people) {
        this.isApproved = false;
        this.originalPerson = originalPerson;
        this.suggestedPerson = suggestedPerson;
        this.people = people;
    }

    public void addAndRemove()  {
            movies.remove(originalValue);
            movies.add(suggestedValue);
}

    /*public void applyChangesToMovieList(Movie updatedMovie) {

        for (int i = 0; i < movies.size(); i++) {
            Movie existingMovie = movies.get(i);
            if (existingMovie.getUuid().equals(updatedMovie.getUuid())) {
                // Replace the old movie with the updated movie
                movies.set(i, updatedMovie);
                break; // UUID is unique, so we can stop looping once we've found the match
            }
        }
    }*/


    public void displayDifferences(Movie originalMovie, Movie suggestedMovie) {
        System.out.println("Suggestion #");
        boolean differenceFound = false;

        if (!originalMovie.getTitle().equalsIgnoreCase(suggestedMovie.getTitle())) {
            System.out.println("Title change:");
            System.out.println("\tOriginal: " + originalMovie.getTitle());
            System.out.println("\tSuggested: " + suggestedMovie.getTitle());
            differenceFound = true;
        }

        if (!originalMovie.getGenre().equalsIgnoreCase(suggestedMovie.getGenre())) {
            System.out.println(originalMovie.getTitle());
            System.out.println("Genre change:");
            System.out.println("\tOriginal: " + originalMovie.getGenre());
            System.out.println("\tSuggested: " + suggestedMovie.getGenre());
            differenceFound = true;
        }

        if (!originalMovie.getLanguage().equalsIgnoreCase(suggestedMovie.getLanguage())) {
            System.out.println("Language change:");
            System.out.println("\tOriginal: " + originalMovie.getLanguage());
            System.out.println("\tSuggested: " + suggestedMovie.getLanguage());
            differenceFound = true;
        }


        if (!differenceFound) {
            System.out.println("No differences found.");
        }

        System.out.println();
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public void setOriginalPerson(Person originalPerson) {
        this.originalPerson = originalPerson;
    }

    public void setSuggestedPerson(Person suggestedPerson) {
        this.suggestedPerson = suggestedPerson;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setOriginalValue(Movie originalValue) {
        this.originalValue = originalValue;
    }

    public void setSuggestedValue(Movie suggestedValue) {
        this.suggestedValue = suggestedValue;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public boolean isApproved() {
        return this.isApproved;
    }

    public Object getOriginalValue() {
        return this.originalValue;
    }

    public Object getSuggestedValue() {
        return this.suggestedValue;
    }


    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public Person getOriginalPerson() {
        return this.originalPerson;
    }

    public Person getSuggestedPerson() {
        return this.suggestedPerson;
    }

    public ArrayList<Person> getPeople() {
        return this.people;
    }
}
