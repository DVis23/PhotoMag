package ru.vsu.cs.dvis.tools.brushes;
import ru.vsu.cs.dvis.tools.Brush;

import java.util.HashMap;
import java.util.Map;

public class Lighten extends Brush {
    private int value;

    public Lighten(String id){
        super(id);
        setType("Lighten");
        value = 0;
        x = 0;
        y = 0;
    }
    public Lighten(){
        setType("Lighten");
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

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("value", value);
        parameters.put("x", x);
        parameters.put("y", y);
        return parameters;
    }
}
