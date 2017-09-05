package pl.sda.javawwa.service;

import java.util.Scanner;

public class ReadFromTerminal {

    private Scanner scanner = new Scanner(System.in);

    public String readOneLine() {

        String scannerData;
        scannerData = scanner.nextLine();

        return (scannerData != null) ? scannerData.replaceAll(",", ".") : null;
    }
}