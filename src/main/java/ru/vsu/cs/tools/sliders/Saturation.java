package ru.vsu.cs.tools.sliders;
import ru.vsu.cs.IToolParameters;
import ru.vsu.cs.tools.Sliders;

import java.util.HashMap;
import java.util.Map;

public class Saturation extends Sliders implements IToolParameters {

    public Saturation(String id){
        super(id);
        setType("Saturation");
        value = 0;
    }
    public Saturation(){
        setType("Saturation");
        value = 0;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("value", value);
        return parameters;
    }
}
