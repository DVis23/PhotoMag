package ru.vsu.cs.dvis.tools;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.Tool;

public abstract class Sliders extends Tool {
    protected int value;

    @JsonCreator
    protected Sliders(@JsonProperty("id") String id) {
        super(id);
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
