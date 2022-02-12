//

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String args[]) throws IOException{
        if (args.length != 1){
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0])); // port number
                Socket clientSocket = serverSocket.accept(); // the only place that uses serverSocket, all the rest use clientSocket
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // return the message to client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // read from client
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
