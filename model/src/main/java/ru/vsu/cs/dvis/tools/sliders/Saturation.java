package ru.vsu.cs.dvis.tools.sliders;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Sliders;

public class Saturation extends Sliders {

    @JsonCreator
    public Saturation(@JsonProperty("id") String id){
        super(id);
        setType("Saturation");
        value = 0;
    }

}
