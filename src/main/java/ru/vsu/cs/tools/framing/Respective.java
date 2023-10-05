package ru.vsu.cs.tools.framing;
import ru.vsu.cs.tools.Framing;

public class Respective extends Framing {
    private int x, y, z;

    public Respective(String id){
        super(id);
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
