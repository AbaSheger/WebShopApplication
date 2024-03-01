package patterns.command;

import models.Pants;
import models.Skirt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Clothing {

    private String type;
    private String material;
    private String size;
    private String color;
    private List<String> adjustments = new ArrayList<>();
    private String length;

    private String fit; // For Pants
    private String neckType; // For TShirt
    private String sleeveLength; // For TShirt
    private String waistline; // For Skirt
    private String pattern; // For Skirt
    private final PropertyChangeSupport support;


    // Constructor
    public Clothing(String type) {
        this.type = type;
        this.support = new PropertyChangeSupport(this);
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

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getNeckType() {
        return neckType;
    }

    public void setNeckType(String neckType) {
        this.neckType = neckType;
    }

    public String getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(String sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

    //PropertyChangeListener support methods
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }


    @Override
    public String toString() {
        return String.format("%s: Material=%s, Size=%s, Color=%s, Adjustments=%s, Length=%s",
                type, material, size, color, adjustments, length);
    }

}
