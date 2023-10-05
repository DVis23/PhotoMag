package ru.vsu.cs.tools.framing;
import ru.vsu.cs.tools.Framing;

public class Rotate extends Framing {
    private int angel;

    public Rotate(String id){
        super(id);
        angel = 0;
    }

    public int getAngel() {
        return angel;
    }
    public void setAngel(int angel) {
        this.angel = angel;
    }
}
