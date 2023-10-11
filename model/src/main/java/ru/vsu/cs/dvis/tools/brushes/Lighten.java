package ru.vsu.cs.dvis.tools.brushes;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Brush;

public class Lighten extends Brush {
    private int value;

    @JsonCreator
    public Lighten(@JsonProperty("id") String id){
        super(id);
        setType("Lighten");
        value = 0;
        x = 0;
        y = 0;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
