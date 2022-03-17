package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for Power-Supplies</p>
 ****/

public class PowerSupply extends Component{

    //the amount of power which this power-supply provides
    private int power;

    //constructor
    public PowerSupply(String name, double price, int powerConsumption, int power) {
        super(name, price, powerConsumption);
        this.power = power;
    }

    //getter / setter
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}


