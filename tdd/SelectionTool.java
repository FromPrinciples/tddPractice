package tdd;

public class SelectionTool {
    Figure selected;
    SelectionMode mode;
    public void mouseDown()
    {
        selected = findFigure();
        if(selected != null)
            mode = SingleSelection(selected);
        else
            mode = MultipleSelection();
    }
    public void mouseMove(){
        mode.mouseMove();
    }
    public void mouseUp(){
        mode.mouseUp();
    }
}
