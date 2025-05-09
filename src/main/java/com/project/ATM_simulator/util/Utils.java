package com.project.ATM_simulator.util;

import java.util.Scanner;

public class Utils {

    private static final Scanner sc = new Scanner(System.in);

    public static String stringInputScanner() {

        return sc.nextLine();
    }

    public static void closeScanner() {
        sc.close();
    }

    public static boolean emailValidator(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("Något gick fel. Mailadressen måste innehålla '@' och '.'");
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex > 0 && dotIndex > atIndex + 1 && dotIndex < email.length() - 1) {

            return true;

        } else {
            System.out.println("Kontrollera att @ kommer före sista punkten, och inte först eller sist");
            return false;
        }
    }

        public static boolean pinCodeValidator(String pinCode) {

            if (pinCode != null && pinCode.length() == 4 && pinCode.matches("\\d+")) {
                return true;
            } else {
                System.out.println("Ett misstag har begåtts. Pinkoden måste vara 4 siffror");
                return false;
            }
        }

        public static int intParser(String pinCode) {

         return Integer.parseInt(pinCode);
        }
    }


