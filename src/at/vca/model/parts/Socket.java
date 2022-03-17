package at.vca.model.parts;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 03/03/2022 | 08:45</p>
 <p>Description: Class for Sockets</p>
 ****/

public class Socket {

    //the amount of contacts on this socket
    private int contacts;
    //the name of the bus protocol of this socket
    private String busProtocol;
    //the tact of the bus of this socket
    private int busTact;

    //constructor
    public Socket(int contacts, String busProtocol, int busTact) {
        this.contacts = contacts;
        this.busProtocol = busProtocol;
        this.busTact = busTact;
    }

    //getter / setter
    public int getContacts() {
        return contacts;
    }

    public void setContacts(int contacts) {
        this.contacts = contacts;
    }

    public String getBusProtocol() {
        return busProtocol;
    }

    public void setBusProtocol(String busProtocol) {
        this.busProtocol = busProtocol;
    }

    public int getBusTact() {
        return busTact;
    }

    public void setBusTact(int busTact) {
        this.busTact = busTact;
    }
}
