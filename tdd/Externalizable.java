package tdd;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Serializable;

public interface Externalizable extends Serializable {
    void writeExternal(ObjectOutput out) throws IOException;
}


