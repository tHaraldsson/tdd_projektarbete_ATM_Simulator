package com.project.ATM_simulator.model.bank;

import com.project.ATM_simulator.model.User;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, User> users;

    public Bank() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public boolean authenticate(String email, int pinCode) {
        User user = users.get(email);
        return user != null && user.getPinCode() == pinCode;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public double getAccountBalance(User user) {
        return users.get(user.getEmail()).getAccountBalance();
    }

}
