package pl.sda.javawwa.model;

import java.util.Arrays;
import java.util.List;

public enum ShapeNames {

    //Do listy dataPointNames wszystko w dopełniaczu
    //jaka jest długość...
    TROJKAT("Trójkąt", "Wzór na pole = a * h * 0,5", Arrays.asList("podstawy a", "wysokości h")),
    KWADRAT("Kwadrat", "Wzór na pole = a * a", Arrays.asList("boku a")),
    PROSTOKAT("Prostokąt", "Wzór na pole = a * b", Arrays.asList("boku a", "boku b")),
    ROWNOLEGLOBOK("Równoległobok", "Wzór na pole = a * h", Arrays.asList("podstawy a", "wysokości h")),
    TRAPEZ("Trapez", "Wzór na pole = ( a + b ) * h * 0,5", Arrays.asList("podstawy a", "podstawy b", "wysokości h")),
    ROMB("Romb", "Wzór na pole (użyjmy przekątnych) = e * f * 0,5", Arrays.asList("przekątnej e", "przekątnej f"));

    String name;
    String equation;
    List<String> dataPointsNames;

    ShapeNames(String name, String equation, List<String> dataPointsNames) {
        this.name = name;
        this.equation = equation;
        this.dataPointsNames = dataPointsNames;
    }


    public String getName() {
        return name;
    }

    public String getEquation() {
        return equation;
    }

    public List<String> getDataPointsNames() {
        return dataPointsNames;
    }
}
