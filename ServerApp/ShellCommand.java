**
 * This class sends commands to the linux shell to be processed. It takes in
 * a string representing a linux command, creates the process and executes the
 * command on the runtime. It then takes all the data it gets back and sends it
 * through the socket to the client.
 */
package serverapp;

import java.io.*;
import java.net.*;
public class shellCommand {
  
    /** inputString the string read from the process */
    private String inputString = null;
    /** process the process used to execute */
    private Process process = null;
    /** socket connection to the server */
    private Socket socket = null;
  
    /** shellCommand class constructor */
    public shellCommand(Socket socket){
       this.socket = socket;
    }
  
    /**
     * this function takes linux commands as strings and sends them
     * to the process
     * @param linuxCommand
     */
    public void enterCommand(String linuxCommand){       
        try
        {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            process = Runtime.getRuntime().exec(linuxCommand);
            BufferedReader bufferedReader = new
                BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((inputString = bufferedReader.readLine()) != null)
            {
                out.println(inputString);
            }
                out.println("end");   // "terminator word" inserted to stop while loop in ThreadClient.
            try
            {
                process.waitFor();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } // end try-catch block
    }
  
}
