package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for PC-CPUs</p>
 ****/

public class CPU extends Component{

    //the socket in which this CPU fits
    private Socket socket;

    //constructor
    public CPU(String name, double price, int powerConsumption, Socket socket) {
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
