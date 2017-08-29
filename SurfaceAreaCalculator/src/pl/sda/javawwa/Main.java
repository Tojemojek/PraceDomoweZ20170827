package pl.sda.javawwa;

import pl.sda.javawwa.model.Shape;
import pl.sda.javawwa.model.ShapeNames;
import pl.sda.javawwa.service.CreateShape;
import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {

        CreateShape makeShape = new CreateShape();



        makeShape.takeDataAndMakeShape(shapes);





    }
}
