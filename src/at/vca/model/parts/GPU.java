package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for GPUs</p>
 ****/

public class GPU extends Component{

    //the size-standard of the cases in which this GPU fits
    private String sizeStandard;

    //constructor
    public GPU(String name, double price, int powerConsumption, String sizeStandard) {
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
