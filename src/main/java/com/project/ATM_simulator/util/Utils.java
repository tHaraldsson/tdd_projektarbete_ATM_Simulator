package com.project.ATM_simulator.util;

import java.util.Scanner;

public class Utils {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputScanner() {

        return sc.nextLine();
    }

    public static void closeScanner() {
        sc.close();
    }
}
