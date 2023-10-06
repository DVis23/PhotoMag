package ru.vsu.cs.tools.brushes;
import ru.vsu.cs.tools.Brush;

public class Align extends Brush {

    public Align(String id){
        super(id);
        setType("Align");
        x = 0;
        y = 0;
    }

    public Align() {
        setType("Align");
        x = 0;
        y = 0;
    }
}
