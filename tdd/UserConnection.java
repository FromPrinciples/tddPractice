package tdd;

import java.io.*;
import java.net.Socket;

public class UserConnection extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public String receive() throws IOException {
        String received = reader.readLine();
        return received;
    }

    public void send(String s) throws IOException{
        writer.write(s);
        writer.newLine();
        writer.flush();
    }

    public void setSocket(Socket s) throws IOException {
        this.socket = s;
        reader = new BufferedReader(
                new InputStreamReader(s.getInputStream())
        );
        writer = new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream()));
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public void run() {
        try{
            Socket s = socketListen.accpet();
            incConnectionCount();
            socketUser.setSocket(s);
            upperRespond(socketUser);
            socketUser.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}




