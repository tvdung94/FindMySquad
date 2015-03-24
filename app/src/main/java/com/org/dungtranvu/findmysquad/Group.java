package com.org.dungtranvu.findmysquad;

import java.util.List;

/**
 * Created by dungtranvu on 3/21/15.
 */
public class Group {
     private String group_name;
     private List<User> user_list;

    public Group(String group_name) {
        this.group_name = group_name;
    }

    public void set_Groupname(String group_name) {
        this.group_name = group_name;
    }

    public String get_Groupname() {
        return group_name;
    }

    public void add(User user) {
        user_list.add(user);
    }

    public void remove(User user) {
        User dummy;
        for (int i = 0 ; i < user_list.size(); i++) {
            dummy = user_list.get(i);
            if (user == dummy)
                user_list.remove(i);
        }
    }
    public void self_deleted() {
        user_list.clear();
    }

    void send_msg_to_all_users() {

    }
}
