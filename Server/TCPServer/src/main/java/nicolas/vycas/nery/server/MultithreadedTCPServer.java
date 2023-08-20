package nicolas.vycas.nery.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class MultithreadedTCPServer {
    private static final ArrayList<Socket> clients = new ArrayList<>();
    private final int port;
    private boolean running = false;
    private ServerSocket serverSocket;
    private static final Logger logger = Logger.getLogger(MultithreadedTCPServer.class.getName());

    public static MultithreadedTCPServer create(int port) {
        return new MultithreadedTCPServer(port);
    }

    private MultithreadedTCPServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            this.running = true;
            MultithreadedTCPServer.logger.log(Level.INFO, "Server started on port {0}", this.port);
            this.loop();
        } catch (IOException e) {
            MultithreadedTCPServer.logger.severe(e.getMessage());
        }
    }

    private void loop() {
        while (this.running) {
            try {
                Socket client = this.serverSocket.accept();
                MultithreadedTCPServer.clients.add(client);
                MultithreadedTCPServer.logger.log(Level.INFO, "Client connected: {0}",
                        client.getInetAddress().getHostAddress());
                new Thread(new ClientHandler(client)).start();
            } catch (IOException e) {
                MultithreadedTCPServer.logger.severe(e.getMessage());
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Welcome to the chat!👋");
                writer.println("You are connected to the server.🌐");
                writer.println("Type your message and press enter to send it to the other clients💬.");
            } catch (IOException e) {
                MultithreadedTCPServer.logger.log(Level.SEVERE, "Error handling client: {0}", e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = reader.readLine()) != null) {
                    MultithreadedTCPServer.logger.log(Level.INFO, "Received message from client: {0}", message);

                    for (Socket client : MultithreadedTCPServer.clients) {
                        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                        if (client != socket) {
                            writer.println(message);
                        } else {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                MultithreadedTCPServer.logger.log(Level.SEVERE, "Error handling client: {0}", e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    MultithreadedTCPServer.logger.log(Level.SEVERE, "Error closing socket: {0}", e.getMessage());
                }
            }
        }
    }
}
