package kg.geeks.rvclick;

import java.io.Serializable;

public class Animal implements Serializable {

    private String name;
    private String color;
    private int weight;
    private int image;

    public Animal(String name, String color, int weight, int image) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
