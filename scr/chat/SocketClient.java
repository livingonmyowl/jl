import java.io.*;
import java.net.Socket;

public class SocketClient {
    final public static int port = 7777;
    final public static String host = "localhost";

    public static void main(String[] args) throws Exception{
        new ClientThreadClass(host, port);
    }
}

class ClientThreadClass {
    private String host;
    private final int port;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader consoleInput;
    private String nick;

    public ClientThreadClass(String host, int port) throws IOException{
        this.host = host;
        this.port = port;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            consoleInput = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Представьтесь: ");
            nick = consoleInput.readLine();
            out.write(nick + "\n");
            out.flush();
            new ReadThread().start();
            new WriteThread().start();
        } catch (IOException e) {
            closeThreads();
        }
    }

    private class ReadThread extends Thread {
        @Override
        public void run() {

            String message;
            try {
                while (true) {
                    message = in.readLine();
                    System.out.println(message);
                }
            } catch (IOException e) {
                closeThreads();
            }
        }
    }

    private class WriteThread extends Thread {

        @Override
        public void run() {
            while (true) {
                String message;
                try {
                    message = consoleInput.readLine();
                    if (message.equals("quit")) {
                        out.write("quit" + "\n");
                        closeThreads();
                        break;
                    } else {
                        out.write(nick + ": " + message + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    closeThreads();

                }

            }
        }
    }
    private void closeThreads() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}