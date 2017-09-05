package pl.sda.javawwa.service;

import pl.sda.javawwa.model.Shape;


public class CalculateArea {
    private Double calculatedsurfaceArea = null;
    private String tmpString;


    public void calculateAndSetAreaAndDescription(Shape shape) {

        switch (shape.getName()) {
            case TROJKAT:
            case ROMB:
                shape.setSurfaceArea(multiplyAllShapeDimensions(shape) * 0.5);
                break;
            case KWADRAT:
                shape.setSurfaceArea(multiplyAllShapeDimensions(shape) * multiplyAllShapeDimensions(shape));
                break;
            case PROSTOKAT:
            case ROWNOLEGLOBOK:
                shape.setSurfaceArea(multiplyAllShapeDimensions(shape));
                break;
            case TRAPEZ:
                shape.setSurfaceArea(calculateTrapezArea(shape));
                break;
        }
        shape.setOpis(makeStringFromDimensionsAndShapeNames(shape));
    }

    private Double multiplyAllShapeDimensions(Shape shape) {
        Double dblTmp = 1D;

        for (Double dbl : shape.getSizes()) {
            dblTmp = dblTmp * dbl;
        }
        return dblTmp;
    }


    private Double calculateTrapezArea(Shape shape) {
        Double tmp = 0D;

        tmp = (shape.getSizes().get(0) + shape.getSizes().get(1))
                * shape.getSizes().get(2) * 0.5;
        return tmp;

    }


    private String makeStringFromDimensionsAndShapeNames(Shape shape) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(shape.getName().getName());
        sb.append("\n").append(shape.getName().getEquation()).append("\n");
        for (int i = 0; i < shape.getName().getDataPointsNames().size(); i++) {
            sb.append("o długości ").append(shape.getName().getDataPointsNames().get(i)).append(" = ").append(shape.getSizes().get(i)).append(", ");
        }
        sb.append("ma powierzchnię ").append(shape.getSurfaceArea());
        return sb.toString();
    }


}