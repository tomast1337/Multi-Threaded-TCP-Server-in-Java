package nicolas.vycas.nery.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class TCPClient {

    private static final Logger logger = Logger.getLogger(TCPClient.class.getName());
    private String host;
    private int port;
    private final ArrayList<String> messages = new ArrayList<>(); // this is the list of messages to be sent to the
    // server
    private Socket socket; // this is the socket used to connect to the server
    private BufferedReader in; // this is the input stream from the server
    private PrintWriter out; // this is the output stream to the server

    public static TCPClient create(String host, int port) {
        TCPClient client = new TCPClient();
        client.host = host;
        client.port = port;
        return client;
    }

    private TCPClient() {
        super();
    }

    private void verifyConnection() throws Exception {
        if (this.socket == null) {
            throw new Exception("Socket not connected");
        }
        if (this.in == null) {
            throw new Exception("Input stream not connected");
        }
        if (this.out == null) {
            throw new Exception("Output stream not connected");
        }
        if (this.socket.isClosed()) {
            throw new Exception("Socket is closed");
        }
    }

    public TCPClient connect() throws UnknownHostException, IOException {
        this.socket = new Socket(this.host, this.port);
        logger.log(Level.INFO, "Connected to {0}:{1}", new Object[]{this.host, this.port});
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        this.in = reader;
        this.out = writer;
        return this;
    }

    public TCPClient disconnect() throws Exception, IOException {
        verifyConnection();
        this.socket.close();
        this.in.close();
        this.out.close();
        return this;
    }

    public void send(String message) {
        TCPClient.logger.log(Level.INFO, "Sending message: {0}", message);
        this.out.println(message);
    }

    public String receive() throws IOException {
        String message = this.in.readLine();
        this.messages.add(message);
        if (message != null) {
            TCPClient.logger.log(Level.INFO, "Received message: {0}", message);
        }
        return message;
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

}
