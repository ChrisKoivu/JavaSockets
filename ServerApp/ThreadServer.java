/*
 * This class describes the ThreadServer object which is a thread
 * created when a client socket connects to the server socket. 
 * A Thread takes in a socket to communicate on and starts its run() method.
 * this class also defines the numerical menu selections from the menu class
 * in the client app to its appropriate Linux command.
 */
package serverapp;

import java.net.*;
import java.io.*;
 
public class ThreadServer extends Thread {
private Socket socket = null;
private shellCommand sC;
PrintWriter out = null;
  public ThreadServer(Socket socket) {
    super("ThreadServer");
    this.socket = socket;
  }
  /*
   * This method starts once the thread has been created and reads
   * a command off the outputStream and as long as it is
   * not 7 it will convert that digit to the string linux command that
   * it stands for. It then uses the processCommand method to have
   * the shellCommand execute the command. If the command is 7 then
   * it closes the socket and reaches the end of its run and the thread
   * dies.
   */
 public void run() {
     System.out.println("Connection established to " + socket);
      try {
        out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
        String inputLine;
        sC=new shellCommand(socket);
        inputLine = in.readLine();
        if(!(inputLine.equals("7"))){
          if(inputLine.equals("1"))
                inputLine="date";
            if(inputLine.equals("2"))
                inputLine="uptime";
            if(inputLine.equals("3"))
                inputLine="free";
            if(inputLine.equals("4"))
                inputLine="netstat";
                if(inputLine.equals("5"))
                    inputLine="who";
            if(inputLine.equals("6"))
               inputLine="ps -de";
           System.out.println("Forking Child Process");
           System.out.println("    Processing Command: " + inputLine);
          processCommand(inputLine);
        }
        out.close();
        in.close();
        socket.close();
        System.out.println("Socket Closed Thread Stopping");
      } catch (IOException e) {
          e.printStackTrace();
      } //end of catch block
    } // end of run method
  
    private void processCommand(String inputCommand){
        sC.enterCommand(inputCommand);
    }
}
