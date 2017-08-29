package pl.sda.javawwa.model;

public class InputData {
    private Double number1;
    private Double number2;
    private Operations operator;
    private Double result;

    public InputData(Double number1, Double number2, Operations operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public Double getNumber1() {
        return number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public Operations getOperator() {
        return operator;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return number1 + " " + operator.getOperator() + " " + number2 + " = " + result;
    }

}
