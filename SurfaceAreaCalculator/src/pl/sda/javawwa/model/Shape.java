package pl.sda.javawwa.model;

public class Shape {

    private Double[] sizes = new Double[4];
    private ShapeNames name;

    public Shape(ShapeNames name, Double[] sizes) {
        this.sizes = sizes;
        this.name = name;
    }

    public Double[] getSizes() {
        return sizes;
    }
}
