package ru.vsu.cs.tools.sliders;
import ru.vsu.cs.tools.Sliders;

public class Contrast extends Sliders {

    public Contrast(String id){
        super(id);
        setType("Contrast");
        value = 0;
    }
    public Contrast(){
        setType("Contrast");
        value = 0;
    }
}
