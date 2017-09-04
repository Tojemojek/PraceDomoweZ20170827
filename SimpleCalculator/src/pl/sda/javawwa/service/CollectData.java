package pl.sda.javawwa.service;

import java.util.Scanner;

public class CollectData {

    private Scanner scanner = new Scanner(System.in);
    private String[] dataCollector = new String[3];

    public void setData(int pos) {
        String scannerData = scanner.nextLine();

        dataCollector[pos] = (scannerData != null) ? scannerData.replaceAll(",", ".") : null;
    }

    public String[] getDataCollector() {
        return dataCollector;
    }

    @Override
    public String toString() {
        return dataCollector[0] + " " + dataCollector[1] + " " + dataCollector[2];
    }
}
