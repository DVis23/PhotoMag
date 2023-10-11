package ru.vsu.cs.dvis.tools.framing;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Framing;

public class Rotate extends Framing {
    private int angel;

    @JsonCreator
    public Rotate(@JsonProperty("id") String id){
        super(id);
        setType("Rotate");
        angel = 0;
    }

    public int getAngel() {
        return angel;
    }
    public void setAngel(int angel) {
        this.angel = angel;
    }
}
