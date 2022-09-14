package tdd;

public class MockConnection extends UserConnection{
    private String setupReceived;

    public String receive() {
        return this.setupReceived;
    }

    public void setSetupReceiveData(String str){
        this.setupReceived = str;
    }
}
