package com.example.descosystem_g22;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    private static final List<User> userlist = new ArrayList<>();

    static {
        userlist.add(new User("admin", "1234"));
        userlist.add(new User("hr", "1422"));
        userlist.add(new User("engineer", "qwerty"));
        userlist.add(new User("customer", "2214"));
    }

    public static List<User> getUserList() {
        return userlist;
    }

    public boolean checkLogIn(User loginUser) {
        for (User user : userlist) {
            if (loginUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public void addNewUser(User loginUser) throws Exception {

        for (User user : userlist) {
            if (loginUser.getUsername().equals(user.getUsername())) {
                System.out.println("A user '" + loginUser.getUsername() + "' already exists!");
                throw new Exception("Username is not unique");
            }
        }

        userlist.add(loginUser);
        System.out.println("New user added: " + loginUser.toString());
    }
}
