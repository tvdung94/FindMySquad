/**
 * Created by dungtranvu on 3/21/15.
 */
package com.org.dungtranvu.findmysquad;

import java.util.List;

public class User {
    private String email;
    private String username;
    private List<Group> groupList;
    public User(String email, String username) {
        this.email = email;
        this.username = username;

    }
    public void sendMSG() {

    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {

        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void addGroupIntoList(Group group) {
        groupList.add(group);
    }

    public void removeGroupFromList(Group group) {

    }
    public Group getIthGroup(int i) {
        return groupList.get(i);
    }

    public void makeGroup() {

    }

    public void addFriendToGroup() {

    }
}
