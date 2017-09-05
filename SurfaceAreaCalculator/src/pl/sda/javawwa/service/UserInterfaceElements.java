package pl.sda.javawwa.service;

import pl.sda.javawwa.model.ShapeNames;

public class UserInterfaceElements {

    public static void displayChooseShapeMessage() {
        for (ShapeNames shp : ShapeNames.values()) {
            System.out.print(String.format("Wprowadź numer: \t%s aby obliczyć pole figury \t%s, \t%s\n", shp.ordinal(), shp.getName(), shp.getEquation()));
        }
    }

    public static void displayWrongShapeChosenMessage(){
        System.out.println("Podany numer figury jest nieprawidłowy, wybierz jeszcze raz");
        displayChooseShapeMessage();
    }

    public static void displayShouldIContinueMessage(){
        System.out.println("Jeśli chcesz kontynuować naciśnij dowolny klawisz poza q");
    }
    public static void displayByeByeMessage(){
        System.out.println("Dziękuję za obliczenia!\nTwoje poprzednie obliczenia to:");
    }

}


