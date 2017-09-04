package pl.sda.javawwa.service;

import pl.sda.javawwa.model.InputData;
import pl.sda.javawwa.model.Operations;

public class Calculate {

    public static void calculateNow(InputData data) {

        switch (data.getOperator()) {
            case ADD:
                data.setResult(data.getNumber1() + data.getNumber2());
                break;
            case SUBSTRACT:
                data.setResult(data.getNumber1() - data.getNumber2());
                break;
            case MULTIPLY:
                data.setResult(data.getNumber1() * data.getNumber2());
                break;
            case DIVIDE:
                data.setResult(data.getNumber1() / data.getNumber2());
                break;
            case POWER:
                data.setResult(Math.pow(data.getNumber1(), data.getNumber2()));
                break;
            case ROOT:
                data.setResult(Math.pow(data.getNumber1(), 1 / data.getNumber2()));
                break;

        }


    }


}
