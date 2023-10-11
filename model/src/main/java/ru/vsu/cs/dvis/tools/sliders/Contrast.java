package ru.vsu.cs.dvis.tools.sliders;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Sliders;

public class Contrast extends Sliders {

    @JsonCreator
    public Contrast(@JsonProperty("id") String id){
        super(id);
        setType("Contrast");
        value = 0;
    }

}
