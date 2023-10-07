package ru.vsu.cs.tools.framing;
import ru.vsu.cs.IToolParameters;
import ru.vsu.cs.tools.Framing;

import java.util.HashMap;
import java.util.Map;

public class Crop extends Framing implements IToolParameters {
    private int x1, x2, x3, x4;
    private int y1, y2, y3, y4;
    private boolean deformation;

    public Crop(String id){
        super(id);
        setType("Crop");
        x1 = 0; x2 = 0; x3 = 0; x4 = 0;
        y1 = 0; y2 = 0; y3 = 0; y4 = 0;
        deformation = false;
    }

    public Crop() {
        setType("Crop");
        x1 = 0; x2 = 0; x3 = 0; x4 = 0;
        y1 = 0; y2 = 0; y3 = 0; y4 = 0;
        deformation = false;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("x1", x1);
        parameters.put("y1", y1);
        parameters.put("x2", x2);
        parameters.put("y2", y2);
        parameters.put("x3", x3);
        parameters.put("y3", y3);
        parameters.put("x4", x4);
        parameters.put("y4", y4);
        return parameters;
    }

    public int getX1() {
        return x1;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public int getX2() {
        return x2;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getX3() {
        return x3;
    }
    public void setX3(int x3) {
        this.x3 = x3;
    }
    public int getX4() {
        return x4;
    }
    public void setX4(int x4) {
        this.x4 = x4;
    }
    public int getY1() {
        return y1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int getY2() {
        return y2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    public int getY3() {
        return y3;
    }
    public void setY3(int y3) {
        this.y3 = y3;
    }
    public int getY4() {
        return y4;
    }
    public void setY4(int y4) {
        this.y4 = y4;
    }
    public boolean isDeformation() {
        return deformation;
    }
    public void setDeformation(boolean deformation) {
        this.deformation = deformation;
    }

}
