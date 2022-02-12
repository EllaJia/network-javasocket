import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException{
        if (args.length != 2)
        {
            System.err.println(
                    "Usage: Java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try(
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream())); // get messages from server
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in)) // read from keyboard
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null){
                out.println(userInput); // send the message out to server (go with PrintWriter)
                System.out.println("echo: " + in.readLine());  // print out messages it receives
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }

    }
}
