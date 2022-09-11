package tdd;

public class TestCase {
    public void runBare() throws Throwable{
        setUp();
        try{
            runTest();
        }finally {
            tearDown();
        }
    }
}
