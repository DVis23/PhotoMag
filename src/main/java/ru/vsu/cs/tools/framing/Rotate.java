package ru.vsu.cs.tools.framing;
import ru.vsu.cs.tools.Framing;

import java.util.HashMap;
import java.util.Map;

public class Rotate extends Framing{
    private int angel;

    public Rotate(String id){
        super(id);
        setType("Rotate");
        angel = 0;
    }

    public Rotate() {
        setType("Rotate");
        angel = 0;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("angel", angel);
        return parameters;
    }

    public int getAngel() {
        return angel;
    }
    public void setAngel(int angel) {
        this.angel = angel;
    }
}
