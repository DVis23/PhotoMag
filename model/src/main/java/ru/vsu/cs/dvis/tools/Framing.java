package ru.vsu.cs.dvis.tools;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.Tool;

public abstract class Framing extends Tool {

    @JsonCreator
    protected Framing(@JsonProperty("id") String id) {
        super(id);
    }
}
