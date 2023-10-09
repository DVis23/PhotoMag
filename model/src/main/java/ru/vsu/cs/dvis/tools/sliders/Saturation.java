package ru.vsu.cs.dvis.tools.sliders;
import ru.vsu.cs.dvis.tools.Sliders;

import java.util.HashMap;
import java.util.Map;

public class Saturation extends Sliders {

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
