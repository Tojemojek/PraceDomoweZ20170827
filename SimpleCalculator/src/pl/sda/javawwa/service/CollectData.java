package pl.sda.javawwa.service;

import java.util.Scanner;

public class CollectData {

    private Scanner scanner = new Scanner(System.in);
    private String scannerData;
    private String[] dataCollector = new String[3];

    public void setData(int pos) {
        do {
            scannerData = scanner.nextLine();
        }
        while (scannerData == null);
        dataCollector[pos] = scannerData.replaceAll(",",".");
    }

    public String getDataCollector(Integer nr) {
        return dataCollector[nr];
    }

    @Override
    public String toString() {
        return dataCollector[0] + " " + dataCollector[1] + " " + dataCollector[2];
    }
}
