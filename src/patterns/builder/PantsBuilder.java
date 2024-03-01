package patterns.builder;

import models.Pants;

public class PantsBuilder {

    private Pants pants = new Pants();


    //build price
    public PantsBuilder setPrice(double price) {
        pants.setPrice(price);
        return this;
    }

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


    public Pants build() {




        return pants;
    }


}
