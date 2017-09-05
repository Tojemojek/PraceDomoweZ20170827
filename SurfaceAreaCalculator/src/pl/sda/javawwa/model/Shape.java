package pl.sda.javawwa.model;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    private ShapeNames name;
    private List<Double> sizes = new ArrayList<>();
    private Double surfaceArea;
    private String opis;

    public Shape(ShapeNames name, List<Double> sizes) {
        this.name = name;
        this.sizes = sizes;
    }

    public ShapeNames getName() {
        return name;
    }

    public List<Double> getSizes() {
        return sizes;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


}
