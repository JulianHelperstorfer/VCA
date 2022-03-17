package at.vca.model.parts;

import java.util.ArrayList;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for CPU-Coolers</p>
 ****/

public class CPUCooler extends Component{

    //the socket of the CPU in which this cooler fits
    private ArrayList<Socket> socket;

    //constructor
    public CPUCooler(String name, double price, int powerConsumption, ArrayList<Socket> socket) {
        super(name, price, powerConsumption);
        this.socket = socket;
    }

    //getter / setter

    public ArrayList<Socket> getSocket() {
        return socket;
    }

    public void setSocket(ArrayList<Socket> socket) {
        this.socket = socket;
    }
}
