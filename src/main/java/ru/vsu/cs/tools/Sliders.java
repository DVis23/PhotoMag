package ru.vsu.cs.tools;

import ru.vsu.cs.Tool;

public abstract class Sliders extends Tool {
    protected int value;

    protected Sliders(String id) {
        super(id);
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
