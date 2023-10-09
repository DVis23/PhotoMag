package ru.vsu.cs.dvis.tools;

import ru.vsu.cs.dvis.Tool;

public abstract class Sliders extends Tool {
    protected int value;

    protected Sliders(String id) {
        super(id);
    }

    protected Sliders() {
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
