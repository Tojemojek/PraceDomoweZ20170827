package pl.sda.javawwa.service;

import pl.sda.javawwa.model.InputData;
import pl.sda.javawwa.model.Operations;

import java.util.List;

public class AddDataToList {

    public static void addDataToList(String[] dataCollector, List<InputData> yourEquations) {



        Operations operations = null;

        for (Operations op : Operations.values()) {
            if (op.getOperator().equals(dataCollector[Operations.OPERATOR])) {
                operations = op;
            }
        }
        Double tmpNo1 = Double.parseDouble(dataCollector[Operations.LICZBA_1]);
        Double tmpNo2 = Double.parseDouble(dataCollector[Operations.LICZBA_2]);
        yourEquations.add(new InputData(tmpNo1, tmpNo2, operations));

    }
}
