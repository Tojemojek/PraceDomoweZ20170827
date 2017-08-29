package pl.sda.javawwa.service;

import java.util.Scanner;

public class ReadFromTerminal {

    private Scanner scanner = new Scanner(System.in);
    private String scannerData;

    public String readOneLine() {
        do {
            scannerData = scanner.nextLine();
        }
        while (scannerData == null);
        return scannerData;
    }
}
