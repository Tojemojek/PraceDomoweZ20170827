package pl.sda.javawwa.service;

import java.util.Scanner;

public class ReadFromTerminal {

    private Scanner scanner = new Scanner(System.in);

    public String readOneLine() {
        String scannerData;
        do {
            scannerData = scanner.nextLine().replaceAll(",",".");
        }
        while (scannerData == null);
        return scannerData;
    }
}