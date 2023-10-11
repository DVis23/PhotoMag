package ru.vsu.cs.dvis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.vsu.cs.dvis.tools.brushes.Align;
import ru.vsu.cs.dvis.tools.brushes.Lighten;
import ru.vsu.cs.dvis.tools.framing.Crop;
import ru.vsu.cs.dvis.tools.framing.Respective;
import ru.vsu.cs.dvis.tools.framing.Rotate;
import ru.vsu.cs.dvis.tools.sliders.Bright;
import ru.vsu.cs.dvis.tools.sliders.Contrast;
import ru.vsu.cs.dvis.tools.sliders.Saturation;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Align.class, name = "Align"),
        @JsonSubTypes.Type(value = Lighten.class, name = "Lighten"),
        @JsonSubTypes.Type(value = Crop.class, name = "Crop"),
        @JsonSubTypes.Type(value = Respective.class, name = "Respective"),
        @JsonSubTypes.Type(value = Rotate.class, name = "Rotate"),
        @JsonSubTypes.Type(value = Bright.class, name = "Bright"),
        @JsonSubTypes.Type(value = Contrast.class, name = "Contrast"),
        @JsonSubTypes.Type(value = Saturation.class, name = "Saturation"),

})
public abstract class Tool {
    private final String id;
    private String type;

    @JsonCreator
    protected Tool(@JsonProperty("id") String id) {
        this.id = id;
        this.type = "";
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
