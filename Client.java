
import java.net.Socket;

public class Client implements Runnable {
    private Socket connectionSocket;
    public double bid_price; // Variable get bid amount
    public String name; // client name
    public String bid_symbol = null; // requested symbol

    public Client(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {

        clientCtrlRef();  //start the thread

    }

    public void startThread() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void clientCtrlRef() {
        try {
            new ClientControl();

        } catch (NumberFormatException e) {
            System.out.println(e);

        } finally {
            try {
                this.connectionSocket.close();
            } catch (Exception e) {
            }
        }
    }
}
