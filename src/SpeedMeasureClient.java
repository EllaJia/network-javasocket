import java.io.*;
import java.net.*;

public class SpeedMeasureClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 7) {
            System.err.println("Error: missing or additional arguments");
            System.exit(1);
        }

        String hostName = args[2];
        int portNumber = Integer.parseInt(args[4]);

        if (portNumber < 1024 | portNumber > 65535){
            System.err.println("Error: port number must be in the range 1024 to 65535");
            System.exit(1);
        }

        try (

                ) {

        } catch () {

        }
    }
}
