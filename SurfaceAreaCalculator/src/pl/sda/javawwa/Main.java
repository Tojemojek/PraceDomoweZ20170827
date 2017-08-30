package pl.sda.javawwa;

import pl.sda.javawwa.model.Shape;
import pl.sda.javawwa.model.ShapeNames;
import pl.sda.javawwa.service.CreateShape;
import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        CreateShape makeShape = new CreateShape();

        do {
            makeShape.takeDataAndMakeShape(shapes);
            if (makeShape.getDoAgain()) {
                System.out.println(shapes.get(shapes.size() - 1));
            } else {
                System.out.println("Dziękuję za użycie programu, twoje obliczenia:");
                shapes.forEach(System.out::println);
            }
        }
        while (makeShape.getDoAgain());
    }
}
