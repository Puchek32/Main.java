package com.company;

import java.util.Scanner;

public class Main {
    public static boolean isInteger(String str, String str1) {
        try {
            Integer.parseInt(str);
            Integer.parseInt(str1);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner console = new Scanner(System.in);
        while (true) {
            int a;
            int b;
                var elements = console.nextLine().split(" ", 3);
                boolean isArabicNumbers = isInteger(elements[0], elements[2]);
            if (isArabicNumbers) {
                a = Integer.parseInt(elements[0]);
                b = Integer.parseInt(elements[2]);
                if (a > 10 || a < 1 || b > 10 || b < 1){
                    throw new Exception("Числа принимаемые на вход больше 10 и не меньше 1");
                }
            } else {
                a = RomanNumeral.valueOf(elements[0]).getValue();
                b = RomanNumeral.valueOf(elements[2]).getValue();
                if (a > 10 || a < 1 || b > 10 || b < 1){
                    throw new Exception("Числа принимаемые на вход больше 10 и не меньше 1");
                }
            }
            var action = Operator.convert(elements[1]);
            int result = action.calculate(a, b);

            System.out.println(isArabicNumbers ? result : RomanNumeral.convertArabicNumber(result));
        }
    }
}
