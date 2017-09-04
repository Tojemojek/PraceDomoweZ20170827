package pl.sda.javawwa.model;

public enum Operations {
    //elementy w formie biernika - kogo? co?
    //do interface Podaj: lub Wpisz
    ADD("+","Pierwszy składnik","Drugi składnik"),
    SUBSTRACT("-","Odjemną","Odjemnik"),
    MULTIPLY("*","Pierwszy czynnik", "Drugi czynnik"),
    DIVIDE("/", "Dzielną", "Dzielnik"),
    POWER("^", "Podstawę potęgi","Wykładnik potęgi"),
    ROOT("?","Pierwiastkowaną", "Stopień pierwiastka");

    public static final Integer LICZBA_1 = 0;
    public static final Integer LICZBA_2 = 1;
    public static final Integer OPERATOR = 2;

    private String operator;
    private String elementPierwszy;
    private String elementDrugi;

    Operations(String operator, String elementPierwszy, String elementDrugi) {
        this.operator = operator;
        this.elementPierwszy = elementPierwszy;
        this.elementDrugi = elementDrugi;
    }


    public String getOperator() {
        return operator;
    }

    public String getElementPierwszy() {
        return elementPierwszy;
    }

    public String getElementDrugi() {
        return elementDrugi;
    }
}
