package opg1;


import java.util.Objects;

public class Bil {
    private String registration;
    private String brand;
    private String model;
    private String color;

    public Bil(String registration, String brand, String model, String color) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registration,brand,model,color);
    }

    @Override
    public boolean equals(Object obj) {
        Bil otherCar = (Bil) obj;
        return (this.registration.equals(otherCar.registration));
    }

    @Override
    public String toString() {
        return "Bil\t{" +
                "registration='" + registration + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

