package ru.vsu.cs.tools.sliders;
import ru.vsu.cs.IToolParameters;
import ru.vsu.cs.tools.Sliders;

import java.util.HashMap;
import java.util.Map;

public class Contrast extends Sliders implements IToolParameters {

    public Contrast(String id){
        super(id);
        setType("Contrast");
        value = 0;
    }
    public Contrast(){
        setType("Contrast");
        value = 0;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("value", value);
        return parameters;
    }
}
