package pl.sda.javawwa.service;

import pl.sda.javawwa.model.Shape;
import pl.sda.javawwa.model.ShapeNames;

import java.util.List;

public class CreateShape {

    private ReadFromTerminal readThis = new ReadFromTerminal();
    private ValidateData validateData = new ValidateData();
    private String tmpString;
    private ShapeNames shapename;
    private Boolean secondTime = false;
    private CalculateArea kalkulator = new CalculateArea();
    private Boolean doAgain = true;

    public Boolean getDoAgain() {
        return doAgain;
    }

    public void takeDataAndMakeShape(List<Shape> shapes) {
        displayShapeCodes();
        tmpString = readThis.readOneLine();

        if (validateData.shouldIContinue(tmpString)) {
            secondTime = false;
            Integer chosenShapeNumber;
            do {
                if (secondTime) {
                    System.out.println("Podany numer figury jest nieprawidłowy, wybierz jeszcze raz");
                    displayShapeCodes();
                    tmpString = readThis.readOneLine();
                }
                chosenShapeNumber = validateData.validateChosenOption(tmpString);
                secondTime = true;
            } while (chosenShapeNumber < 0);
            shapename = ShapeNames.values()[chosenShapeNumber];
            finallyCreateShapeAndCalculateArea(shapename, shapes);
        } else doAgain = false;
    }

    private void displayShapeCodes() {
        for (ShapeNames shp : ShapeNames.values()) {
            System.out.print(String.format("Wprowadź numer: \t%s aby obliczyć pole figury \t%s wg wzoru \t%s\n", shp.ordinal(), shp.getName(), shp.getEquation()));
        }
        System.out.println("Aby zakończyć wybierz 'q'");
    }

    private Double readDoubleWithComment(String comment) {
        System.out.println(comment);
        secondTime = false;
        Double tmp;

        do {
            if (secondTime) {
                System.out.println("Podana wartość musi być liczbą dodatnia");
            }
            tmpString = readThis.readOneLine();
            tmp = validateData.validateDimension(tmpString);
            secondTime = true;
        } while (tmp < 0);
        return tmp;

    }

    private void finallyCreateShapeAndCalculateArea(ShapeNames shapename, List<Shape> shapes) {
        switch (shapename) {
            case KWADRAT:
                makeKwadrat(shapes);
                kalkulator.calculateKwadratArea(shapes.get(shapes.size() - 1));
                break;
            case PROSTOKAT:
                makeProstokat(shapes);
                kalkulator.calculateProstokatArea(shapes.get(shapes.size() - 1));
                break;
            case ROWNOLEGLOBOK:
                makeRownoleglobok(shapes);
                kalkulator.calculateRownoleglobokArea(shapes.get(shapes.size() - 1));
                break;
            case TRAPEZ:
                makeTrapez(shapes);
                kalkulator.calculateTrapezArea(shapes.get(shapes.size() - 1));
                break;
            case TROJKAT:
                makeTrojkat(shapes);
                kalkulator.calculateTrojkatArea(shapes.get(shapes.size() - 1));
                break;
            case ROMB:
                makeRomb(shapes);
                kalkulator.calculateRombArea(shapes.get(shapes.size() - 1));
                break;
        }

    }


    private void makeKwadrat(List<Shape> shapes) {
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");

        shapes.add(new Shape(shapename, tmpList));

    }

    private void makeProstokat(List<Shape> shapes) {
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj b");

        shapes.add(new Shape(shapename, tmpList));
    }

    private void makeRownoleglobok(List<Shape> shapes) {
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj h");

        shapes.add(new Shape(shapename, tmpList));
    }

    private void makeRomb(List<Shape> shapes) {
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj przekątną e");
        tmpList[1] = readDoubleWithComment("Podaj przekątną f");
        tmpList[2] = 0.5D;

        shapes.add(new Shape(shapename, tmpList));
    }


    private void makeTrojkat(List<Shape> shapes) {
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj h");
        tmpList[2] = 0.5D;


        shapes.add(new Shape(shapename, tmpList));
    }


    private void makeTrapez(List<Shape> shapes) {
        Double[] tmpList = new Double[5];
        tmpList[0] = readDoubleWithComment("Podaj a");
        tmpList[1] = readDoubleWithComment("Podaj b");
        tmpList[2] = readDoubleWithComment("Podaj h");
        tmpList[3] = 0.5D;

        shapes.add(new Shape(shapename, tmpList));
    }


}
