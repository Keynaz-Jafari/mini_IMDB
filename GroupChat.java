package org.example;

import org.example.Comment;
import org.example.Member;

import java.util.ArrayList;

public class GroupChat {
    
    private String name;
    private ArrayList<Member> members;
    private ArrayList<Comment> messages;


    public GroupChat(String name) {
        this.name = name;
        this.members=new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setMessages(ArrayList<Comment> messages) {
        this.messages = messages;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Member> getMembers() {
        return this.members;
    }

    public ArrayList<Comment> getMessages() {
        return this.messages;
    }
}
