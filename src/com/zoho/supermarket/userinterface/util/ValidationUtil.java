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
            System.err.println("Invalid input Try again!");
        }
    }

    public static int getValidIntegerInput() throws NumberFormatException{
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.matches("^[0-9]+")) {
                return Integer.parseInt(input);
            }
            System.err.println("Invalid input Try again!");
        }
    }
    public static int getValidProductQtyInput(){
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+")) {
                System.out.println("Invalid input Try again!");
                continue;
            }
            try {
                if(Integer.parseInt(input)>0) {
                    return Integer.parseInt(input);
                }
            }
            catch (NumberFormatException e){
                System.err.println("Invalid input Try again!");
            }
        }
    }

    public static double getValidPriceInput() throws NumberFormatException{
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+.+[0-9]+") && !input.matches("^[0-9]+")&&!input.matches("^.+[0-9]")) {
                System.err.println("Invalid input Try again!");
                continue;
            }
            try {
                if (!(Double.parseDouble(input) == 0)) {
                    return Double.parseDouble(input);
                }
            }
            catch (NumberFormatException e){
                System.err.println("Invalid input Try again!");
            }
            System.err.println("Invalid input Try again!");
        }
    }

    public static double getValidDiscountInput() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+.+[0-9]") && !input.matches("^[0-9]+")&&!input.matches("^.+[0-9]")) {
                System.err.println("Invalid input Try again!");
                continue;
            }
            if (!(Double.parseDouble(input) == 0) && !(Double.parseDouble(input) >100)) {
                return Double.parseDouble(input);
            }
            System.err.println("Invalid input Try again!");
        }
    }

    public static int getValidEnumInput(int maxValue) {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches("^[0-9]+")) {
                System.err.println("Invalid input Try again!");
                continue;
            }
            int validValue = Integer.parseInt(input);
            if (validValue > 0 && validValue <= maxValue) {
                return validValue;
            }
            System.err.println("Invalid input Try again!");
        }
    }

    public static String getValidUserName(){
        String input;
        while (true){
            input=sc.nextLine();
            if(input.matches("([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}")){
                return input;
            }
            System.err.println("Invalid input Try again!");
        }
    }

    public static String getValidPassword() {
        String input = sc.nextLine();
        while (!input.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")) {
            System.err.println("Invalid Password Try again!");
            System.out.println("Note: The password should contain a lower case character, upper case character," +
                    "\n it must start with an alphabet" +
                    "\n Atleast one digit, a total of 8 - 20 character length, and special characters like ['@#$%^&-+=()']");
            System.out.println("Enter your password correctly: ");
            input = new Scanner(System.in).nextLine();
        }
        return input;
    }
    public static boolean isInstanceValid(Object instance) {return instance != null;}

    public static boolean isListValid(List list) {
        return !(list == null || list.isEmpty());
    }

    public static String getValidConfirmPassword(String password) {
        String input;
        while (true) {
            input=sc.nextLine();
            if (password.equals(input)) {
                return input;
            } else {
                System.err.println("password mismatched Try again!!");
            }
        }

    }
}

