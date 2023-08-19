package nicolas.vycas.nery.server;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        logger.info("Starting server...");
        // try to get the port from environment variable
        String port = System.getenv("PORT");
        if (port == null) {
            logger.info("PORT environment variable not found, using default port 8080");
            port = "8080";
        }
        // try to parse the port to integer
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(port);
        } catch (NumberFormatException e) {
            logger.severe("Invalid port number: " + port);
            System.exit(1);
        }
        MultithreadedTCPServer server = MultithreadedTCPServer.create(portNumber);
        server.run();
    }
}
