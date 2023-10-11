package ru.vsu.cs.dvis.tools.brushes;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Brush;

public class Align extends Brush {

    @JsonCreator
    public Align(@JsonProperty("id") String id){
        super(id);
        setType("Align");
        x = 0;
        y = 0;
    }

}
