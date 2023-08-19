package nicolas.vycas.nery.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {

    private Logger logger;
    private Socket client;
    private ArrayList<Socket> clients;

    public ClientHandler(Socket client, ArrayList<Socket> clients) {
        this.client = client;
        this.clients = clients;
        this.logger = Logger.getLogger(ClientHandler.class.getName());
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String message;
            while ((message = reader.readLine()) != null) {
                this.logger.info("Received message from client: " + message);
                for (Socket client : clients) {
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(message);
                }
            }
        } catch (IOException e) {
            this.logger.info("Error handling client: " + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                this.logger.severe("Error closing socket: " + e.getMessage());
            }
        }

    }

}
