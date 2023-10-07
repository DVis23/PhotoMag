package ru.vsu.cs.tools.framing;
import ru.vsu.cs.IToolParameters;
import ru.vsu.cs.tools.Framing;

import java.util.HashMap;
import java.util.Map;

public class Respective extends Framing implements IToolParameters {
    private int x, y, z;

    public Respective(String id){
        super(id);
        setType("Respective");
        x = 0; y = 0; z = 0;
    }

    public Respective() {
        setType("Respective");
        x = 0; y = 0; z = 0;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("x", x);
        parameters.put("y", y);
        parameters.put("z", z);
        return parameters;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }
}
