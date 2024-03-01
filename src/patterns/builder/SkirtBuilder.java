package patterns.builder;
import models.Skirt ;
public class SkirtBuilder{

    private Skirt skirts = new Skirt();


    //build price

    public SkirtBuilder setPrice(double price) {
        skirts.setPrice(price);
        return this;
    }


    public SkirtBuilder setSize(String size) {
        skirts.setSize(size);
        return this;
    }

    public SkirtBuilder setMaterial(String material) {
        return this;
    }


    public SkirtBuilder setColor(String color) {

        skirts.setColor(color);
        return this;
    }




    public Skirt build() {
        return skirts;
    }


}
