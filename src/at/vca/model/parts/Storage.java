package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for storages (HDD/SSD)</p>
 ****/

public class Storage extends Component{

    //the amount of storage
    private int storageSize;

    //constructor
    public Storage(String name, double price, int powerConsumption, int storageSize) {
        super(name, price, powerConsumption);
        this.storageSize = storageSize;
    }

    //getter / setter
    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }
}
