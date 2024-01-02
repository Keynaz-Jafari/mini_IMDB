package org.example;

import org.example.Member;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class MemberService { // database az person ha ke member ham jozehshe
    private static ArrayList<Person> people = new ArrayList<>(); // works like the database of the members in the website

    // while signing up, check if the email already exists or not
    public static boolean emailExists(String email){
        for(Person person: people){
            if (person instanceof Member){

                if(((Member)person).getEmail().equalsIgnoreCase(email))
                    return true;
            }

        }
        return false;
    }


// asliii (defaulte signup ro member boodan grftm)
    public static Member signup2(String username, String password, String email, String name, String LastName, AccessLevel accessLevel) {
        if(emailExists(email)){
            return null; // can not sign up , already exists
        }
        else {
            // Creating a new member with given details and adding it to the members list
            Member newMember = new Member(username, password, email,name,LastName,accessLevel);
            people.add(newMember);
            return newMember; // Sign up successful
        }

    }


    public static Member login(String username, String password){
        for (Person person : people) {
            if(person instanceof Member){
                if (((Member)person).getUsername().equalsIgnoreCase(username) && ((Member)person).getPassword().equalsIgnoreCase(password)) {
                    return (Member)person;
                }
            }

        }
        return null;
    }

    public static boolean removePerson(Person personToRemove){
        if(personToRemove!=null && people.contains(personToRemove)){
            return people.remove(personToRemove);
        }
        return false;
    }


    public static void setPeople(ArrayList<Person> people) {
        MemberService.people = people;
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }
}

