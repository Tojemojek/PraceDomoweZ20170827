package pl.sda.javawwa;

import pl.sda.javawwa.model.DisplayMessages;
import pl.sda.javawwa.model.InputData;
import pl.sda.javawwa.model.Operations;
import pl.sda.javawwa.service.AddDataToList;
import pl.sda.javawwa.service.Calculate;
import pl.sda.javawwa.service.CollectData;
import pl.sda.javawwa.service.ValidateData;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<InputData> yourEquations = new ArrayList<>();

    public static void main(String[] args) {
        Boolean notFinishedFlag = true;
        CollectData collectData = new CollectData();
        ValidateData validateData = new ValidateData();

        System.out.println(DisplayMessages.displayMenu);
        System.out.println(DisplayMessages.displayOperators);

        do {
            if (yourEquations.size() > 0) {
                System.out.print(DisplayMessages.recentCalculations);
                yourEquations.forEach(System.out::println);
                System.out.println(DisplayMessages.nextCalculation);
            }

            System.out.println(DisplayMessages.operator);
            collectData.setData(Operations.OPERATOR);
            if (collectData.getDataCollector()[Operations.OPERATOR].equals("q")) break;

            System.out.println(DisplayMessages.firstentry);
            collectData.setData(Operations.LICZBA_1);

            System.out.println(DisplayMessages.secondentry);
            collectData.setData(Operations.LICZBA_2);

            if (validateData.validator(collectData)) {
                AddDataToList.addDataToList(collectData.getDataCollector(), yourEquations);
                Calculate.calculateNow(yourEquations.get(yourEquations.size() - 1));
                System.out.println("Twoje działanie: " + yourEquations.get(yourEquations.size() - 1));
            } else {
                System.out.println(DisplayMessages.incorrectData);
                System.out.println(String.format("Co to za dziwne obliczenia %s %s %s ?",
                        collectData.getDataCollector()[Operations.LICZBA_1],
                        collectData.getDataCollector()[Operations.OPERATOR],
                        collectData.getDataCollector()[Operations.LICZBA_2]));
            }

            System.out.println(DisplayMessages.continueOrNot);
            collectData.setData(Operations.OPERATOR);;

            if (collectData.getDataCollector()[Operations.OPERATOR].equals("q")) {
                notFinishedFlag = false;
                System.out.println(DisplayMessages.byebye);
                yourEquations.forEach(System.out::println);
            }

        }
        while (notFinishedFlag);

    }


}


