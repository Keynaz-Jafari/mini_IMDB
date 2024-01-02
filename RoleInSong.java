package org.example;

public class RoleInSong {
    private Role role;
    private Person person;

    public RoleInSong(Role role, Person person) {
        this.role = role;
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return this.person;
    }

    public Role getRole() {
        return this.role;
    }


}
