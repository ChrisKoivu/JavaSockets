/*
 * This Application is the main server side program.
 * It creates a socket on port 4444 which then listens for the client
 * trying to access the port. Once it hears a client trying
 * to access the port it spawns a new thread that accepts the
 * access onto its socket. The Server then goes on listening for more
 * clients tring to access, and repeats the process for each
 * subsequent connection request.
 */
package serverapp;

import java.net.*;
import java.io.*;
 
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;
 
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server Started. Listening on port 4444...");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }
      
        while (listening)
        new ThreadServer(serverSocket.accept()).start();
      
        serverSocket.close();
    }
}
