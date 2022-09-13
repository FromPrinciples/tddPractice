package tdd;

import java.awt.*;

import static sun.tools.tree.Statement.empty;

public class EmptyRectangleTest {
    public void setUp(){
        Rectangle empty = new Rectangle(0, 0, 0, 0);
    }

    public void testEmpty(){
        assertTrue(empty.isEmpty());
    }
    public void testWidth(){
        assertEquals(0.0, empty.getWidth(), 0.0);
    }

}
