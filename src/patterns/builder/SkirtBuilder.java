package patterns.builder;
import models.Skirt ;
public class SkirtBuilder{

    private Skirt skirts = new Skirt();


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

    public SkirtBuilder setWaistLine(String waistline) {
         skirts.setWaistline(waistline);
         return this;
    }

    public SkirtBuilder setPattern (String pattern) {
         skirts.setPattern (pattern);
         return this;
    }


    public Skirt build() {
        return skirts;
    }

    @Override
    public String toString() {
        return "SkirtBuilder{" +
                "skirts=" + skirts +
                '}';
    }
}
