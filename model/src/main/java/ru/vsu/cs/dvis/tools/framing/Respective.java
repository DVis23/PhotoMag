package ru.vsu.cs.dvis.tools.framing;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.vsu.cs.dvis.tools.Framing;

public class Respective extends Framing {
    private int x, y, z;

    @JsonCreator
    public Respective(@JsonProperty("id") String id){
        super(id);
        setType("Respective");
        x = 0; y = 0; z = 0;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }
}
