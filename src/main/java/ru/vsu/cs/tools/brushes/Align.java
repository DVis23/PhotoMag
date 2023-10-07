package ru.vsu.cs.tools.brushes;
import ru.vsu.cs.IToolParameters;
import ru.vsu.cs.tools.Brush;

import java.util.HashMap;
import java.util.Map;

public class Align extends Brush implements IToolParameters {

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

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("x", x);
        parameters.put("y", y);
        return parameters;
    }
}
