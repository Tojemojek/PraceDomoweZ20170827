package pl.sda.javawwa.model;

public enum ShapeNames {
    KWADRAT("Kwadrat","Wzór na pole = a * a"),
    PROSTOKAT("Prostokąt","Wzór na pole = a * b"),
    ROWNOLEGLOBOK("Równoległobok","Wzór na pole = a * h"),
    TRAPEZ("Trapez","Wzór na pole = ( a + b ) * h * 0,5"),
    TROJKAT("Trójkąt","Wzór na pole = a * h * 0,5"),
    ROMB("Romb","Wzór na pole (użyjmy przekątnych) = e * f * 0,5");

    String name;
    String equation;

    ShapeNames(String name, String equation) {
        this.name = name;
        this.equation = equation;
    }

    public String getName() {
        return name;
    }

    public String getEquation() {
        return equation;
    }


}
