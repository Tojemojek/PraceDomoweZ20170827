package pl.sda.javawwa.service;

public class ValidateData {

    private final Integer ERRROR_CODE = -1;


    public Boolean shouldIContinue(String validowane) {
        if (validowane.equals("q")) {
            return false;
        }
        return true;
    }

    public Integer validateChosenOption(String validowane) {
        Integer tmp;

        try {
            tmp = Integer.parseInt(validowane);
            if (tmp > 5) {
                return ERRROR_CODE;
            } else
                return tmp;
        } catch (NumberFormatException e) {
            return ERRROR_CODE;
        }
    }

    public Double validateDimension(String validowane) {
        Double tmp;
        try {
            tmp = Double.parseDouble(validowane);
            if (tmp > 0D) {
                return tmp;
            } else return (double) ERRROR_CODE;
        } catch (NumberFormatException e) {
            return (double) ERRROR_CODE;
        }
    }
}

