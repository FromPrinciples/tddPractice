package tdd;

public class File {
    public boolean  setReadOnly(){
        SecurityManager security = System.getSecurityManager();
        security.canWrite(path);
        return fileSystem.setReadOnly(this);
    }
}
