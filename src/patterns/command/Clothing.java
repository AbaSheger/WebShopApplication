package patterns.command;

import java.util.ArrayList;
import java.util.List;

public class Clothing {

    private String type;
    private String material;
    private String size;
    private String color;
    private List<String> adjustments = new ArrayList<>();
    private String length;

    // Constructor
    public Clothing(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<String> adjustments) {
        this.adjustments = adjustments;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void addAdjustment(String adjustment) {
        if (adjustment != null && !adjustment.isEmpty()) {
            adjustments.add(adjustment);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: Material=%s, Size=%s, Color=%s, Adjustments=%s, Length=%s",
                type, material, size, color, adjustments, length);
    }

}
