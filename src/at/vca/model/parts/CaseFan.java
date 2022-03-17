package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for PC-Case-Fans</p>
 ****/

public class CaseFan extends Component{

    //the size-standard of cases in which this fan fits
    private String sizeStandard;

    //constructor
    public CaseFan(String name, double price, int powerConsumption, String sizeStandard) {
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
