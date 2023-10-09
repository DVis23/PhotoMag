package ru.vsu.cs.dvis.tools;

import ru.vsu.cs.dvis.Tool;

public abstract class Brush extends Tool {
    protected int x;
    protected int y;

    protected Brush(String id) {
        super(id);
    }

    protected Brush() {
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
