package ru.vsu.cs.dvis.tools;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.Tool;

public abstract class Brush extends Tool {
    protected int x;
    protected int y;

    @JsonCreator
    protected Brush(@JsonProperty("id") String id) {
        super(id);
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
}
