package org.example;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.UUID;

public class Person implements Sender, ReportReceiver {
    public void reportReceived() {
    }
    @Override
    public void SendNotification() {
    }

    private String name;
    private String LastName;
    private UUID uuid;
    private ArrayList<Member> followers;
    private ArrayList<Role> roles;


    public Person(String name, String lastName) { // baraye signup kardan tooye member azin estefade krdim
        this.name = name;
        this.LastName = lastName;
        this.uuid = UUID.randomUUID(); // az karbar nemigire , system baraye harkas uuid dorost mikone
        this.followers = new ArrayList<>();
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setFollowers(ArrayList<Member> followers) {
        this.followers = followers;
    }

    public void setUid(UID uid) {
        this.uuid = uuid;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public UUID getuuid() {
        return this.uuid;
    }

    public String getLastName() {
        return this.LastName;
    }

    public ArrayList<Member> getFollowers() {
        return this.followers;
    }

    public ArrayList<Role> getRoles() {
        return this.roles;
    }
    public String getName() {
        return this.name;
    }


}
