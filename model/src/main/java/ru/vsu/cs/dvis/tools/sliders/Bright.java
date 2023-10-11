package ru.vsu.cs.dvis.tools.sliders;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Sliders;

public class Bright extends Sliders {

    @JsonCreator
    public Bright(@JsonProperty("id") String id){
        super(id);
        setType("Bright");
        value = 0;
    }

}
