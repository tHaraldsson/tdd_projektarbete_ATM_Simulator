package com.project.ATM_simulator.util;

import java.util.Scanner;

public class Utils {

    private static final Scanner sc = new Scanner(System.in);

    public static String stringInputScanner() {

        return sc.nextLine();
    }

    public static int intInputScanner() {

        return Integer.parseInt(sc.nextLine());
    }

    public static void closeScanner() {
        sc.close();
    }
}
