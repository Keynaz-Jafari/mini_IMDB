package org.example;

public class RoleInMovie {
    private MovieRole movieRole;
    private Person person;


    public RoleInMovie(MovieRole movieRole, Person person) {
        this.movieRole = movieRole;
        this.person = person;
    }

    public void setMovieRole(MovieRole movieRole) {
        this.movieRole = movieRole;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

    public MovieRole getMovieRole() {
        return this.movieRole;
    }

}
