package clientApp;
import java.io.*;
import java.net.*;

/**
 * Application use java socket API to connect to a network
 * server and gets statistics from the host.
 * @author Chris Koivu
 */
public class Main {
    /** optionNumber for function desired */
    private int optionNumber;   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{       
       String ipAddress = args[0];
        
         
         cs Client_Socket = new Client_Socket(new Socket(ipAddress, 4444));
         cs.clientConnect();
         cs.clientComm();        
         
    } //  end main method
}
