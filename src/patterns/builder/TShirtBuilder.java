package patterns.builder;

import models.TShirt;

public class TShirtBuilder {


   private TShirt tshirt = new TShirt();


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

    public TShirtBuilder setSleeves(String sleeves) {
        tshirt.setSleeves(sleeves);
        return this;

    }

    public TShirtBuilder setNeckType(String neckType) {
        tshirt.setNeckType(neckType);
        return this;
    }

    public TShirt build() {
        return tshirt;
    }

    @Override
    public String toString() {
        return "TShirtBuilder{" +
                "tshirt=" + tshirt +
                '}';
    }
}
