package ru.vsu.cs.tools.sliders;
import ru.vsu.cs.tools.Sliders;

public class Saturation extends Sliders {

    public Saturation(String id){
        super(id);
        setType("Saturation");
        value = 0;
    }
    public Saturation(){
        setType("Saturation");
        value = 0;
    }
}
