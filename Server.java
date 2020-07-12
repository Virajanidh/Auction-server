//main Server
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //Server will be listing to incoming connections on port 2000
    public static final int BASE_PORT = 2000;

    public static void main(String[] args) {

        new StockDB();
        new OfferDB();
        FirstDisplayControl guiControl = new FirstDisplayControl();
        Thread guiThread = new Thread(guiControl);
        guiThread.start();  //server thread start
        Server server = new Server();
        try {
            server.serverLoop();
        } catch (IOException e) {
        }
    }

    public void serverLoop() throws IOException {
        ServerSocket serverSocket = new ServerSocket(BASE_PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            Client newClient = new Client(socket);
            newClient.startThread();
        }
    }

}
