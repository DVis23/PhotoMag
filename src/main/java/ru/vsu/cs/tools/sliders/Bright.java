package ru.vsu.cs.tools.sliders;
import ru.vsu.cs.tools.Sliders;

public class Bright extends Sliders {

    public Bright(String id){
        super(id);
        setType("Bright");
        value = 0;
    }
    public Bright(){
        setType("Bright");
        value = 0;
    }
}
