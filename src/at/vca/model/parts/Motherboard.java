package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for Motherboards</p>
 ****/

public class Motherboard extends Component{

    //the name of the chipset of this motherboard
    private String chipset;
    //the socket for the CPU on this motherboard
    private Socket socket;

    //constructor
    public Motherboard(String name, double price, int powerConsumption, String chipset, Socket socket) {
        super(name, price, powerConsumption);
        this.chipset = chipset;
        this.socket = socket;
    }

    //getter / setter
    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
