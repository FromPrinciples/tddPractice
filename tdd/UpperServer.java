package tdd;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpperServer {
    private String receivedStr;

    public String receive(){
        return null;
    }
    public String getReceived() {
        return receivedStr;
    }

    public void testUpper() throws IOException{
        UpperServer upperServer = new UpperServer();
        assertEquals("TESTING", upperServer.toUpper("testing"));
    }
    public String toUpper (String aString){
        return aString.toUpperCase();
    }

    public void testReceive(){
        MockConnection mockConnection = new MockConnection();
        String str = "testing";
        mockConnection.setReceiveData(str);
        us.receove(mockConnection);
        assertEquals(str, us.getReceived());
    }

    public void testConnect() throws IOException, UnknownHostException, InterruptedException {
        int port = 50000;
        us.serve(port);
        Socket socket = new Socket("localhost", port);
        Thread.sleep(100);
        us.close();
        assertEquals(1, us.getConnectionCount());
    }
}

class ListenThread extends Thread {
    public void run() {
        try {
            Socket socket = socketListen.accept();
            incConnectionCount();
            socketUser.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void incConnectionCount() {
        connectionCount++;
    }

    public void serve(int port) throws IOException {
        socketListen = new ServerSocket(port);
        new ListenThread().start();
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public void close() throws IOException {
        socketListen.close();
    }

    public void testUpperRespond() throws IOException {
        MockConnection mockConnection = new MockConnection();
        String teststr = "testing";
        mockConnection.setReceiveData(teststr);
        us.upperRespond(mockConnection);
        assertEquals(teststr.toUpperCase(), mockConnection.sentStr());
    }

    public String receive() {
        return this.setupReceived;
    }
    public void setReceiveData(String str) {
        this.setupReceived = str;
    }

    private String sent;
    public void send(String s) {
        sent = s;
    }
    public String sentStr() {
        return this.sent;
    }

    public void upperRespond(UserConnection s) throws IOException {
        s.send(toUpper(s.receive()));
    }

    public void testServe() throws IOException, InterruptedException {
        int port = 50000;
        us.serve(port);
        Socket socket = new Socket("localhost", port);

        BufferdReader bufferdReader = new BufferdReader(
                new InputStreamReader(socket.getInputStream()));
        BufferdWriter bufferdWriter = new BufferdWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bufferdWriter.write("iwanttoupper");
        bufferdWriter.newLine();
        bufferdWriter.flush();
        String actual = bufferdReader.readLine();
        String expected = "IWANTOUPPER";

        Thread.sleep(100);
        us.close();
        assertEquals(expected, actual);
    }


}
