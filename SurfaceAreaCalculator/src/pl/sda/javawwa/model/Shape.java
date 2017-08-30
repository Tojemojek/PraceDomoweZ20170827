package pl.sda.javawwa.model;

public class Shape {

    private ShapeNames name;
    private Double[] sizes = new Double[4];
    private String opis;

    public Shape(ShapeNames name, Double[] sizes) {
        this.sizes = sizes;
        this.name = name;
    }

    public Double getSizes(Integer sizePosition) {
        return sizes[sizePosition];
    }

    public void setSurfaceArea(Double surfaceArea) {
        sizes[4] = surfaceArea;
    }

    public ShapeNames getName() {
        return name;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return opis;
    }
}
