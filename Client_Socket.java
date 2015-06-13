package clientApp;
import java.net.*;
import java.io.*;
/**
 *
 * @author Chris Koivu
 */
public class Client_Socket extends Thread {
   private Socket client = null;
   private String line;
   private PrintWriter outData = null;
   private BufferedReader inData = null;
   private Boolean active;
   Menu mnu = new Menu();    
  
           
   Client_Socket(Socket client) {
     this.client=client;     
   }
   
   public void clientConnect()throws IOException {
       try {
         outData = new PrintWriter(client.getOutputStream(), true);
         inData = new BufferedReader(new InputStreamReader(
         client.getInputStream()));
         System.out.println("Connection established to " + client.getInetAddress());
         
         active = true;
       } catch (UnknownHostException e) {
          System.err.println("Don't know about host" + client.getInetAddress());
          System.exit(1);
       } catch (IOException e) {
          System.err.println("Couldn't get I/O for "
          + "the connection");
          System.exit(1);
       }      
      
   }// end clientConnect
   
   public void clientComm() throws IOException{
      BufferedReader stdIn = new BufferedReader(
       new InputStreamReader(System.in));
       String userInput;
       String inStream;
       mnu.displayMenu();
           
       while ((userInput = stdIn.readLine()) != null) {
         if (mnu.validChoice(mnu.getReqNumber(userInput))){
            outData.println(userInput);
            inStream = inData.readLine();
            if(inStream.equals("Bye!")){
                System.out.println(inStream);
                break;
            }               
            System.out.println(inStream);               
         }  // end outer if block         
         mnu.displayMenu();
       }   // end while loop   
      
   } //end clientComm
           
  
}
