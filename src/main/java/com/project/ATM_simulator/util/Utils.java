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

    public static int intParser(String pinCode) {
        return Integer.parseInt(pinCode);
    }

    public static double doubleParser(String userInput) {
        return Double.parseDouble(userInput);
    }
}


