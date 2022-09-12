package tdd;

import java.lang.reflect.Method;

abstract class Report {
//    abstract void print();
    String printMessage;
    Report(String printMessage){
        this.printMessage = printMessage;
    }
    void print(){
        switch (printMessage){
            case "printHTML" :
                printHTML();
                break;
            case "printXML" :
                printXML();
                break;
        };
        Method runMethod = getClass().getMethod(printMessage, null);
        runMethod.invoke(this, new Class[0]);
    }
    void printHTML() {}
    void printXML() {}
}

class HTMLReport extends Report {
    void print(){
        // ...
    }
}
class XMLPort extends Report{
    void print(){
        // ...
    }
}
