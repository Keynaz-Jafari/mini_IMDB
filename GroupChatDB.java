package org.example;

import java.util.ArrayList;

public class GroupChatDB {
    private static ArrayList<GroupChat> groupChats=new ArrayList<>();


    public static void setGroupChats(ArrayList<GroupChat> GroupChats) {
       groupChats = GroupChats;
    }

    public static ArrayList<GroupChat> getGroupChats() {
        return groupChats;
    }
}
