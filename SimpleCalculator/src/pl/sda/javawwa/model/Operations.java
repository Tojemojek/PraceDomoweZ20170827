package pl.sda.javawwa.model;

public enum Operations {
    ADD("+"), SUBSTRACT("-"), MULTIPLY("*"), DIVIDE("/"), POWER("^"), ROOT("?");

    private String operator;

    Operations(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
