package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for PC-Cases</p>
 ****/

public class Case extends Component{

    //The size-standard of the case (e.g.ATX)
    private String sizeStandard;

    //constructor
    public Case(String name, double price, int powerConsumption, String sizeStandard) {
        super(name, price, powerConsumption);
        this.sizeStandard = sizeStandard;
    }

    //getter / setter
    public String getSizeStandard() {
        return sizeStandard;
    }

    public void setSizeStandard(String sizeStandard) {
        this.sizeStandard = sizeStandard;
    }
}
