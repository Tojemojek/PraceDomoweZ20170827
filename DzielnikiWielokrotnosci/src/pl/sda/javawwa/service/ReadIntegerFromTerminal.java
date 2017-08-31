package pl.sda.javawwa.service;

import com.sun.javafx.binding.StringFormatter;

import java.util.Scanner;

public class ReadIntegerFromTerminal {

    public static Integer readOneLineWithComment(String myComment) {
        String scannerData;
        Integer tmpInt = null;
        Boolean secondTry = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.format("Podaj %s dodatnią liczbę całkowitą", myComment));

        do {
            if (secondTry) {
                System.out.println(String.format("Coś się nie udało - spróbuj jeszcze raz, podaj %s dodatnią liczbę całkowitą", myComment));
            }

            scannerData = scanner.nextLine().replaceAll(",", ".");
            try {
                tmpInt = Integer.parseInt(scannerData);
            } catch (NumberFormatException e) {
                tmpInt = null;
            }
            secondTry = true;
        }
        while (tmpInt == null || tmpInt < 0);
        return tmpInt;
    }

}