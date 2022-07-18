import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;

public class SocketServer {
    public static LinkedList<ServerThreadClass> serverList = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        while (true) {
            if (completableFuture.isDone() || Connection.first) {
                Connection.first = false;
                completableFuture = CompletableFuture.runAsync(new Connection());
            }
        }
    }

    public static class Connection implements Runnable {
        final private static int port = 7777;
        private static boolean first = true;

        @Override
        public void run (){
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                serverList.add(new ServerThreadClass(socket));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class ServerThreadClass extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerThreadClass(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String message;
        try {
            message = in.readLine();
            for (ServerThreadClass element : SocketServer.serverList) {
                element.send("В чате новый участник: " + message);
            }
            try {
                while (true) {
                    message = in.readLine();
                    if (message.equals("quit")) {
                        closeThreads();
                        break;
                    }
                    System.out.println(message);
                    for (ServerThreadClass element : SocketServer.serverList) {
                        if (!element.equals(this))
                            element.send(message);
                    }
                }
            }
            catch (NullPointerException ignored) {}

        } catch (IOException e) {
            closeThreads();
        }
    }

    private void send(String message) {
        try {
            out.write(message + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void closeThreads() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerThreadClass element : SocketServer.serverList) {
                    if(element.equals(this)) element.interrupt();
                    SocketServer.serverList.remove(this);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
