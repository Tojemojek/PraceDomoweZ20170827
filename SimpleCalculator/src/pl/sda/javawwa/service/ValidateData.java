package pl.sda.javawwa.service;

import pl.sda.javawwa.model.DisplayMessages;
import pl.sda.javawwa.model.InputData;
import pl.sda.javawwa.model.Operations;

import java.util.List;

public class ValidateData {

    private Operations opetatorsName = null;
    private Double[] tmpNumbers = new Double[2];
    private CollectData localCollecData;

    public Boolean validator(CollectData collectData, List<InputData> inputDataList) {
        this.localCollecData = collectData;

        Boolean correctFirstNumber, correctSecondNumber, correctOperator;

        correctFirstNumber = validateIfDouble(collectData.getDataCollector(0), 0);
        correctOperator = validateOperator(collectData.getDataCollector(1));
        correctSecondNumber = validateSecondNumber(collectData.getDataCollector(2));

        if (correctFirstNumber && correctOperator && correctSecondNumber) {
            inputDataList.add(new InputData(tmpNumbers[0], tmpNumbers[1], opetatorsName));
            return true;
        } else {
            System.out.println(DisplayMessages.incorrectData);
            System.out.println(localCollecData);
            return false;
        }
    }

    private Boolean validateOperator(String operator) {

        for (Operations op : Operations.values()) {
            if (op.getOperator().equals(operator)) {
                opetatorsName = op;
                return true;
            }
        }
        return false;
    }

    private Boolean validateIfDouble(String maybeNumber, int posNumber) {
        Double tmpNumber;
        try {
            tmpNumber = Double.parseDouble(maybeNumber);
            tmpNumbers[posNumber] = tmpNumber;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Boolean validateSecondNumber(String maybeNumber) {
        if (validateIfDouble(maybeNumber, 1)) {
            switch (opetatorsName) {
                case DIVIDE:
                    return validateDivisionByzero(tmpNumbers[1]);
                case POWER:
                    return validatePower(tmpNumbers[1]);
                case ROOT:
                    return validateRoot(tmpNumbers[1]);
            }
            return true;
        } else return false;
    }


    private Boolean validateDivisionByzero(Double tmp) {
        if (tmp.equals(0D)) {
            return false;
        }
        return true;
    }

    private Boolean validatePower(Double tmp) {
        if (tmp < 0 || tmp != Math.floor(tmp)) {
            return false;
        }
        return true;
    }

    private Boolean validateRoot(Double tmp) {
        if (tmp <= 0 || tmp != Math.floor(tmp)) {
            return false;
        }
        return true;
    }

}


