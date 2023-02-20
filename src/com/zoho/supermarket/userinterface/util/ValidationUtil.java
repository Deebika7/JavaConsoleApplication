package com.zoho.supermarket.userinterface.util;


import java.util.List;
import java.util.Scanner;

public class ValidationUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static boolean isStrValid(String string) {
        return string.equalsIgnoreCase("y") || string.equalsIgnoreCase("n");
    }

    public static String getValidStringInput() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.matches("^[a-zA-Z0-9]+( [a-zA-Z0-9.]+)*$")) {
                return input;
            }
            System.out.println("Invalid input Try again!");
        }
    }

    public static String getValidCharacterInput() {
        String Choice;
        while (true) {
            if (isStrValid(Choice = sc.nextLine())) {
                break;
            } else {
                System.out.println("Invalid input try again!");
            }
        }
        return Choice;
    }

    public static int getValidIntegerInput() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.matches("^[0-9]+")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid input Try again!");
        }
    }
    public static int getValidProductQtyInput() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+")) {
                System.out.println("Invalid input Try again!");
                continue;
            }
            if(Integer.parseInt(input)>0) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid input Try again!");
        }
    }

    public static double getValidPriceInput() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+.+[0-9]+") && !input.matches("^[0-9]+")) {
                System.out.println("Invalid input Try again!");
                continue;
            }
            if (!(Double.parseDouble(input) == 0)) {
                return Double.parseDouble(input);
            }
            System.out.println("Invalid input Try again!");
        }
    }

    public static double getValidDiscountInput() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+.+[0-9]") && !input.matches("^[0-9]+")) {
                System.out.println("Invalid input Try again!");
                continue;
            }
            if (!(Double.parseDouble(input) == 0) && !(Double.parseDouble(input) >100)) {
                return Double.parseDouble(input);
            }
            System.out.println("Invalid input Try again!");
        }
    }

    public static int getValidEnumInput(int maxValue) {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+")) {
                System.out.println("Invalid input Try again!");
                continue;
            }
            int validValue = Integer.parseInt(input);
            if (validValue > 0 && validValue <= maxValue) {
                return validValue;
            }
            System.out.println("Invalid input Try again!");
        }
    }
    public static boolean isInstanceValid(Object instance) {return instance != null;}

    public static boolean isListValid(List list) {
        return (list == null || list.isEmpty());
    }


}
