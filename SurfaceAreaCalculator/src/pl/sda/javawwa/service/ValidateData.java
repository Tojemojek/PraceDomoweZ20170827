package pl.sda.javawwa.service;

import pl.sda.javawwa.model.ShapeNames;

public class ValidateData {


    public Boolean shouldIContinue(String validowane) {
        if (validowane.equals("q")) {
            return false;
        }
        return true;
    }

    public Boolean validateChosenOption(String validowane) {
        Integer tmp;
        try {
            tmp = Integer.parseInt(validowane);
            if (tmp > ShapeNames.values().length - 1 && tmp < 0) {
                return false;
            } else
                return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Boolean validateIfPositiveDouble(String validowane) {
        Double tmp;
        try {
            tmp = Double.parseDouble(validowane);
            if (tmp > 0D) {
                return true;
            } else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

