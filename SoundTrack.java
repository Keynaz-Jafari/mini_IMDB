package org.example;

import java.util.ArrayList;

public class SoundTrack {
    private String name;
    private String otherDetails;
    private ArrayList<RoleInSong> rolesInSong;

    public SoundTrack(String name, ArrayList<RoleInSong> rolesInSong) {
        this.name = name;
        this.rolesInSong = rolesInSong;
    }

    public void setRolesInSong(ArrayList<RoleInSong> rolesInSong) {
        this.rolesInSong = rolesInSong;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }


    public String getOtherDetails() {
        return this.otherDetails;
    }

    public ArrayList<RoleInSong> getRolesInSong() {
        return this.rolesInSong;
    }

    public String getName() {
        return this.name;
    }


}
