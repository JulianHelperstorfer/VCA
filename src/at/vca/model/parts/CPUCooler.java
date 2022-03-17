package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for CPU-Coolers</p>
 ****/

public class CPUCooler extends Component{

    //the socket of the CPU in which this cooler fits
    private Socket socket;

    //constructor
    public CPUCooler(String name, double price, int powerConsumption, Socket socket) {
        super(name, price, powerConsumption);
        this.socket = socket;
    }

    //getter / setter
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
