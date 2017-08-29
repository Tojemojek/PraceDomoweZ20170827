package pl.sda.javawwa.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pl.sda.javawwa.model.Shape;
import pl.sda.javawwa.model.ShapeNames;

import java.util.Arrays;
import java.util.List;

public class CreateShape {

    private ReadFromTerminal readThis = new ReadFromTerminal();
    private ValidateData validateData = new ValidateData();
    private Integer chosenShapeNumber;
    private String tmpString;
    private ShapeNames shapename;
    private Boolean secondTime = false;


    public void takeDataAndMakeShape(List<Shape> shapes) {
        displayShapeCodes();
        tmpString = readThis.readOneLine();
        secondTime = false;
        do {
            if (secondTime){
                System.out.println("Podany numer figury jest nieprawidłowy, wybierz jeszcze raz");
                displayShapeCodes();
            }
            chosenShapeNumber = validateData.validateChosenOption(tmpString);
            secondTime = true;
        } while (chosenShapeNumber < 0);
        shapename = ShapeNames.values()[chosenShapeNumber];
        choseCorrectMethod(shapename,shapes);

    }

    private void displayShapeCodes() {
        for (ShapeNames shp : ShapeNames.values()) {
            System.out.print(String.format("Wprowadź numer: \t%s aby obliczyć pole figury \t%s wg wzoru \t%s\n", shp.ordinal(), shp.getName(), shp.getEquation()));
        }
    }

    private Double readDoubleWithComment(String comment) {
        System.out.println("Wpisz " + comment);
        secondTime = false;
        Double tmp;

        tmpString = readThis.readOneLine();

        do {
            if (secondTime){
                System.out.println("Podana wartość musi być liczbą dodatnia");
            }
            tmp = validateData.validateDimension(tmpString);
            secondTime = true;
        } while (tmp < 0);
        return tmp;

    }


    private void makeKwadrat(List<Shape> shapes){
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");

        for (int i = 1; i <5; i++){
            tmpList[i] = 1D;
        }
        shapes.add(new Shape(ShapeNames.KWADRAT, tmpList));

    }

    private void makeProstokat(List<Shape> shapes){
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj b");

        for (int i = 2; i <5; i++){
            tmpList[i] = 1D;
        }
        shapes.add(new Shape(ShapeNames.PROSTOKAT, tmpList));
    }

    private void makeRownoleglobok(List<Shape> shapes){
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj h");

        for (int i = 2; i <5; i++){
            tmpList[i] = 1D;
        }
        shapes.add(new Shape(ShapeNames.ROWNOLEGLOBOK, tmpList));
    }

    private void makeRomb(List<Shape> shapes){
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj przekątną e");
        tmpList[1] = readDoubleWithComment("Podaj przekątną f");
        tmpList[2] = 0.5D;

        for (int i = 3; i <5; i++){
            tmpList[i] = 1D;
        }
        shapes.add(new Shape(ShapeNames.ROMB, tmpList));
    }


    private void makeTrojkat(List<Shape> shapes){
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj h");
        tmpList[2] = 0.5D;

        for (int i = 3; i <5; i++){
            tmpList[i] = 1D;
        }

        shapes.add(new Shape(ShapeNames.TROJKAT, tmpList));
    }



    private void makeTrapez(List<Shape> shapes){
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj b");
        tmpList[2] = readDoubleWithComment("Podaj h");
        tmpList[3] = 0.5D;

        for (int i = 4; i <5; i++){
            tmpList[i] = 1D;
        }
        shapes.add(new Shape(ShapeNames.TRAPEZ, tmpList));
    }



    private void choseCorrectMethod(ShapeNames shapename,List<Shape> shapes){
        switch (shapename) {
            case KWADRAT:
                makeKwadrat(shapes);
                break;
            case PROSTOKAT:
                makeProstokat(shapes);
                break;
            case ROWNOLEGLOBOK:
                makeRownoleglobok(shapes);
                break;
            case TRAPEZ:
                makeTrapez(shapes);
                break;
            case TROJKAT:
                makeTrojkat(shapes);
                break;
            case ROMB:
                makeRomb(shapes);
                break;
        }

    }


}
