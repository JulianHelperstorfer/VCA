package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for RAMs</p>
 ****/

public class RAM extends Component{

    //the name of the module of this RAM
    private String module;
    //the height of the module of this RAM
    private double moduleHeight;

    //constructor
    public RAM(String name, double price, int powerConsumption, String module, double moduleHeight) {
        super(name, price, powerConsumption);
        this.module = module;
        this.moduleHeight = moduleHeight;
    }

    //getter / setter
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getModuleHeight() {
        return moduleHeight;
    }

    public void setModuleHeight(double moduleHeight) {
        this.moduleHeight = moduleHeight;
    }
}
