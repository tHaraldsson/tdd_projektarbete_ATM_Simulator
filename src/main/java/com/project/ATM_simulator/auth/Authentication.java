package com.project.ATM_simulator.auth;

import com.project.ATM_simulator.model.User;

public class Authentication {

    public boolean authenticate(String email, int pinCode, User user) {
        if (!(email.equals(user.getEmail()) && pinCode == user.getPinCode())) {
            return false;
        }
        return true;
    }
}
