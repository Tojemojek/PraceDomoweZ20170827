package pl.sda.javawwa;

import pl.sda.javawwa.model.Shape;
import pl.sda.javawwa.model.ShapeNames;
import pl.sda.javawwa.service.CreateShape;
import pl.sda.javawwa.service.ReadFromTerminal;
import pl.sda.javawwa.service.UserInterfaceElements;
import pl.sda.javawwa.service.ValidateData;
import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) {
        CreateShape makeShape = new CreateShape();
        ValidateData validateData = new ValidateData();
        Boolean shouldIContinue = true;
        ReadFromTerminal readFromTerminal= new ReadFromTerminal();

        do {
            makeShape.takeDataFromTerminalAndAddNewShapeToList(shapes);

            //czemu przy każdym przejściu czyta mi wszystkie kształty!!!
            System.out.println(shapes.get(shapes.size()-1).getOpis());

            UserInterfaceElements.displayShouldIContinueMessage();
            shouldIContinue = validateData.shouldIContinue(readFromTerminal.readOneLine());

            if (!shouldIContinue) {
                System.out.println("Dziękuję za użycie programu, twoje obliczenia:");
                shapes.forEach(s -> System.out.println(s.getOpis()));
            }
        }
        while (shouldIContinue);
    }
}
