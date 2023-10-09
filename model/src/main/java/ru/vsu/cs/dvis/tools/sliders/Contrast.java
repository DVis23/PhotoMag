package ru.vsu.cs.dvis.tools.sliders;
import ru.vsu.cs.dvis.tools.Sliders;

import java.util.HashMap;
import java.util.Map;

public class Contrast extends Sliders {

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
