package patterns.builder;

import models.Pants;

public class PantsBuilder {

    private Pants pants = new Pants();


    public  PantsBuilder setSize (String size) {
        pants.setSize(size);
        return this;
    }


    public PantsBuilder  setMaterial(String material) {
        pants.setMaterial(material);
        return this;
    }


    public PantsBuilder setColor(String color) {
        pants.setColor(color);
        return this;
    }

    public PantsBuilder setLength(String length) {
        pants.setLength(length);
        return this;
    }

    public PantsBuilder setFit(String fit) {
        pants.setFit(fit);
        return this;
    }


    public Pants build() {


        return pants;
    }
}
