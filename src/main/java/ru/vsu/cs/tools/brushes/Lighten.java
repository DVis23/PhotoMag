package ru.vsu.cs.tools.brushes;
import ru.vsu.cs.tools.Brush;

public class Lighten extends Brush {
    private int value;

    public Lighten(String id){
        super(id);
        value = 0;
        x = 0;
        y = 0;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
