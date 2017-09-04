package pl.sda.javawwa.service;

import pl.sda.javawwa.model.Operations;

public class ValidateData {

    private Operations opetatorsName = null;
    private Double[] tmpNumbers = new Double[2];

    public Boolean validator(CollectData collectData) {


        Boolean correctFirstNumber, correctSecondNumber, correctOperator;

        correctOperator = validateOperator(collectData.getDataCollector()[Operations.OPERATOR]);
        correctFirstNumber = validateFirstNumber(collectData.getDataCollector()[Operations.LICZBA_1]);
        correctSecondNumber = validateSecondNumber(collectData.getDataCollector()[Operations.LICZBA_2]);

        if (correctFirstNumber && correctOperator && correctSecondNumber) {
            return true;
        } else {
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

    private Boolean validateIfNotNegativeDouble(String maybeNumber, int posNumber) {
        if (validateIfDouble(maybeNumber, posNumber)) {
            if (tmpNumbers[posNumber] > 0) {
                return true;
            }
        }
        return false;
    }


    private Boolean validateIfInteger(String maybeNumber, int posNumber) {
        if (validateIfDouble(maybeNumber, posNumber)) {
            if (Math.floor(tmpNumbers[posNumber]) == tmpNumbers[posNumber]) {
                return true;
            }
        }
        return false;
    }

    private Boolean validateIfNotZero(String maybeNumber, int posNumber) {
        if (validateIfDouble(maybeNumber, posNumber)) {
            if (tmpNumbers[posNumber] != 0) {
                return true;
            }
        }
        return false;
    }


    private Boolean validateIfNotNegativeInteger(String maybeNumber, int posNumber) {
        if (validateIfInteger(maybeNumber, posNumber)) {
            if (tmpNumbers[posNumber] >= 0) {
                return true;
            }
        }
        return false;
    }

    private Boolean validateIfPositiveInteger(String maybeNumber, int posNumber) {
        if (validateIfInteger(maybeNumber, posNumber)) {
            if (tmpNumbers[posNumber] > 0) {
                return true;
            }
        }
        return false;
    }


    private Boolean validateFirstNumber(String maybeNumber) {
        if (validateIfDouble(maybeNumber, Operations.LICZBA_1)) {
            switch (opetatorsName) {
                case ROOT:
                    return validateIfNotNegativeDouble(maybeNumber, Operations.LICZBA_1);
            }
            return true;
        } else return false;
    }

    private Boolean validateSecondNumber(String maybeNumber) {
        if (validateIfDouble(maybeNumber, Operations.LICZBA_2)) {
            switch (opetatorsName) {
                case DIVIDE:
                    return validateIfNotZero(maybeNumber, Operations.LICZBA_2);
                case POWER:
                    return validateIfNotNegativeInteger(maybeNumber, Operations.LICZBA_2);
                case ROOT:
                    return validateIfPositiveInteger(maybeNumber, Operations.LICZBA_2);
            }
            return true;
        } else return false;
    }

}


