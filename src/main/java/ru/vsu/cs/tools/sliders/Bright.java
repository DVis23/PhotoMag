package ru.vsu.cs.tools.sliders;
import ru.vsu.cs.tools.Sliders;

import java.util.HashMap;
import java.util.Map;

public class Bright extends Sliders{

    public Bright(String id){
        super(id);
        setType("Bright");
        value = 0;
    }
    public Bright(){
        setType("Bright");
        value = 0;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("value", value);
        return parameters;
    }
}
