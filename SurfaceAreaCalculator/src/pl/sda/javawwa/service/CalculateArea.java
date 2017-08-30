package pl.sda.javawwa.service;

import pl.sda.javawwa.model.Shape;


public class CalculateArea {
    private Double calculatedsurfaceArea = null;
    private String tmpString;

    public void calculateTrojkatArea(Shape localShape) {
        calculatedsurfaceArea = localShape.getSizes(0)
                * localShape.getSizes(1)
                * localShape.getSizes(2);
        localShape.setSurfaceArea(calculatedsurfaceArea);
        tmpString = String.format("Twój trójkąt o podstawie %f i wysokości %f ma pole powierzchni %f",
                localShape.getSizes(0),
                localShape.getSizes(1),
                localShape.getSizes(4));
        localShape.setOpis(tmpString);
    }

    public void calculateKwadratArea(Shape localShape) {
        calculatedsurfaceArea = localShape.getSizes(0)
                * localShape.getSizes(0);
        localShape.setSurfaceArea(calculatedsurfaceArea);
        tmpString = String.format("Twój kwadrat o boku %f ma pole powierzchni %f",
                localShape.getSizes(0),
                localShape.getSizes(4));
        localShape.setOpis(tmpString);
    }

    public void calculateProstokatArea(Shape localShape) {
        calculatedsurfaceArea = localShape.getSizes(0)
                * localShape.getSizes(1);
        localShape.setSurfaceArea(calculatedsurfaceArea);
        tmpString = String.format("Twój prostokąt o bokach %f i %f ma pole powierzchni %f",
                localShape.getSizes(0),
                localShape.getSizes(1),
                localShape.getSizes(4));
        localShape.setOpis(tmpString);
    }

    public void calculateRownoleglobokArea(Shape localShape) {
        calculatedsurfaceArea = localShape.getSizes(0)
                * localShape.getSizes(1);
        localShape.setSurfaceArea(calculatedsurfaceArea);
        tmpString = String.format("Twój rownoległobok o podstawie %f i wysokości %f ma pole powierzchni %f",
                localShape.getSizes(0),
                localShape.getSizes(1),
                localShape.getSizes(4));
        localShape.setOpis(tmpString);
    }

    public void calculateTrapezArea(Shape localShape) {
        calculatedsurfaceArea =
                (localShape.getSizes(0) + localShape.getSizes(1))
                        * localShape.getSizes(2)
                        * localShape.getSizes(3);
        localShape.setSurfaceArea(calculatedsurfaceArea);
        tmpString = String.format("Twój trapez o podstawach %f i %f oraz wysokości %f ma pole powierzchni %f",
                localShape.getSizes(0),
                localShape.getSizes(1),
                localShape.getSizes(2),
                localShape.getSizes(4));
        localShape.setOpis(tmpString);
    }

    public void calculateRombArea(Shape localShape) {
        calculatedsurfaceArea = localShape.getSizes(0)
                * localShape.getSizes(1)
                * localShape.getSizes(2);
        localShape.setSurfaceArea(calculatedsurfaceArea);
        tmpString = String.format("Twój romb o przekątnych %f i %f ma pole powierzchni %f",
                localShape.getSizes(0),
                localShape.getSizes(1),
                localShape.getSizes(4));
        localShape.setOpis(tmpString);
    }

}
