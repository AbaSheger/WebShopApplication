package patterns.builder;

import models.TShirt;

public class TShirtBuilder {


   private TShirt tshirt = new TShirt();


   //build price

    public TShirtBuilder setPrice(double price) {
        tshirt.setPrice(90.00);
        return this;
    }


    public TShirtBuilder setSize(String size) {
        tshirt.setSize(size);
        return this;
    }

    public TShirtBuilder setMaterial(String material) {
        tshirt.setMaterial(material);
        return this;
    }


    public TShirtBuilder setColor(String color) {
        tshirt.setColor(color);
        return this;
    }


    public TShirt build() {
        return tshirt;
    }


}
