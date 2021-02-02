package com.craig;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            while(true) {
                String sourceRadixInput = scanner.nextLine();
                if (!checkRadixInput(sourceRadixInput)) {
                    System.out.println("Error");
                    break;
                }
                String sourceNumberInput = scanner.nextLine();
                int sourceRadix = Integer.parseInt(sourceRadixInput);
                if (!checkNumberInput(sourceNumberInput,sourceRadix)) {
                    System.out.println("Error");
                    break;
                }
                String targetRadixInput = scanner.nextLine();
                if (!checkRadixInput(targetRadixInput)) {
                    System.out.println("Error");
                    break;
                }
                int targetRadix = Integer.parseInt(targetRadixInput);
                if (sourceNumberInput.contains(".")) {
                    convertFractions(sourceRadix,sourceNumberInput,targetRadix);
                } else {
                    System.out.println(convertInteger(sourceRadix,sourceNumberInput,targetRadix));
                }
                break;
            }
        } catch (Exception ex) {

        }
    }

    public static boolean checkRadixInput(String input) {
        if (input.matches("[0-9]+")) {
            if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 36) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean checkNumberInput(String input, int sourceRadix) {
        if (sourceRadix == 1) {
            for (int i = 0; i < input.length(); i++) {
                if (Character.getNumericValue(input.charAt(i)) != sourceRadix) {
                    return false;
                };
            }
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) >= sourceRadix) {
                return false;
            };
        }
        return true;
    }

    public static void convertFractions(int sourceRadix, String sourceNumber, int targetRadix) {
        String [] values = sourceNumber.split("\\.");
        String fractionalPart = values[1];
        String integerValue = convertInteger(sourceRadix,values[0],targetRadix);

        double decimalValue = 0.00;
        for (int i = 1; i <= fractionalPart.length(); i++) {
            decimalValue += Character.digit(fractionalPart.charAt(i -1),sourceRadix) / Math.pow(sourceRadix,i);
        }
        StringBuilder fractionalNewBase = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            double value = decimalValue * targetRadix;
            String [] intAndFraction = String.valueOf(value).split("\\.");
            fractionalNewBase.append(convertInteger(10,intAndFraction[0],targetRadix));
            decimalValue = Double.parseDouble("0." + intAndFraction[1]);
        }
        System.out.println(integerValue + "." + fractionalNewBase);
    }

    public static String convertInteger(int sourceRadix, String sourceNumber, int targetRadix) {
        int decimalNumber;
        if (sourceRadix == 1) {
            decimalNumber = sourceNumber.length();
        } else {
            decimalNumber = Integer.parseInt(sourceNumber,sourceRadix);
        }

        StringBuilder conversion = new StringBuilder();
        if (targetRadix == 1) {
            for (int i = 0; i < decimalNumber; i++) {
                conversion.append('1');
            }
        } else {
            conversion.append(Integer.toString(decimalNumber,targetRadix));
        }

        return conversion.toString();
    }
}
