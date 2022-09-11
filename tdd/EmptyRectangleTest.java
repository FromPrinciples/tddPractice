package tdd;

import static sun.tools.tree.Statement.empty;

public class EmptyRectangleTest {
    public void setUp(){
        Reactangle empty = new Reactangle(0, 0, 0, 0);
    }

    public void testEmpty(){
        assertTrue(empty.isEmpty());
    }
    public void testWidth(){
        assertEquals(0.0, empty.getWidth(), 0.0);
    }

}
