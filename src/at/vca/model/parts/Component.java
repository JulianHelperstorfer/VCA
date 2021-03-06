package at.vca.model.parts;

import java.io.Serializable;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Super-Class for PC-Components</p>
 ****/

public class Component implements Serializable {

    private static final long serialVersionUID = -3670912818810238985L;

    //name of the component
    private String name;
    //price of the component
    private double price;
    //power consumption of the component
    private int powerConsumption;

    //constructor
    public Component(String name, double price, int powerConsumption) {
        this.name = name;
        this.price = price;
        this.powerConsumption = powerConsumption;
    }

    @Override
    public String toString() {
        return name;
    }

    //getter / setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
