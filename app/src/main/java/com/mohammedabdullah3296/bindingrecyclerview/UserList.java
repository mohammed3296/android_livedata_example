package com.mohammedabdullah3296.bindingrecyclerview;

import java.util.List;

public class UserList {

    List<User> users ;

    public UserList() {
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
