package nicolas.vycas.nery.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class MultithreadedTCPServer {
    private ArrayList<Socket> clients = new ArrayList<>();
    private int port;
    private boolean running = false;
    private ServerSocket serverSocket;
    private Logger logger;

    public static MultithreadedTCPServer create(int port) {
        return new MultithreadedTCPServer(port);
    }

    private MultithreadedTCPServer(int port) {
        this.port = port;
        this.logger = Logger.getLogger(MultithreadedTCPServer.class.getName());
    }

    public void run() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            this.running = true;
            this.logger.info("Server started on port " + this.port);
            this.loop();
        } catch (Exception e) {
            this.logger.severe(e.getMessage());
        }

    }

    private void loop() {
        while (this.running) {
            try {
                Socket client = this.serverSocket.accept();
                this.clients.add(client);
                this.logger.info("Client connected: " + client.getInetAddress().getHostAddress());
                new Thread(new ClientHandler(client, clients)).start();
            } catch (Exception e) {
                this.logger.severe(e.getMessage());
            }
        }
    }

}
