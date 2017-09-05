package pl.sda.javawwa.service;

import pl.sda.javawwa.model.Shape;
import pl.sda.javawwa.model.ShapeNames;

import java.util.ArrayList;
import java.util.List;

public class CreateShape {


    private ReadFromTerminal dane = new ReadFromTerminal();

    private ShapeNames nazwaTmp;
    private Shape ksztaltTmp;
    private List<Double> dimensionsTmp = new ArrayList<>();
    private ValidateData waliduj = new ValidateData();
    private CalculateArea oblicz = new CalculateArea();



    public void takeDataFromTerminalAndAddNewShapeToList(List<Shape> shapes) {
        Boolean chooseShapeSecondTimeShape = false;
        nazwaTmp = null;
        ksztaltTmp = null;
        dimensionsTmp.clear();

        while (nazwaTmp == null) {
            if (chooseShapeSecondTimeShape) {
                UserInterfaceElements.displayWrongShapeChosenMessage();
            } else {
                UserInterfaceElements.displayChooseShapeMessage();
            }
            getFromTerminalShapeName();
            chooseShapeSecondTimeShape = true;
        }
        getFromTerminalDimensions();
        shapes.add(new Shape(nazwaTmp,dimensionsTmp));
        oblicz.calculateAndSetAreaAndDescription(shapes.get(shapes.size()-1));
    }


    private void getFromTerminalShapeName() {

        String tmp = dane.readOneLine();
        Integer intTmp = null;

        if (waliduj.validateChosenOption(tmp)) {
            intTmp = Integer.parseInt(tmp);
            nazwaTmp = ShapeNames.values()[intTmp];
        }
    }

    private void getFromTerminalDimensions() {
        Double dblTmp = null;
        List<String> dataPointsNamesTmp = nazwaTmp.getDataPointsNames();

        for (int i = 0; i < dataPointsNamesTmp.size(); ) {
            System.out.println(String.format("Podaj długość %s", dataPointsNamesTmp.get(i)));
            String tmp = dane.readOneLine();
            if (waliduj.validateIfPositiveDouble(tmp)) {
                dblTmp = Double.parseDouble(tmp);
                dimensionsTmp.add(dblTmp);
                i++;
            }
        }
    }

}
