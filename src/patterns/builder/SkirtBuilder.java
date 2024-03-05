package patterns.builder;
import models.Skirt ;
public class SkirtBuilder{

    private Skirt skirts = new Skirt();


    public SkirtBuilder setId(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        skirts.setId(id);
        return this;
    }


    public SkirtBuilder setPrice(double price) {
        skirts.setPrice(price);
        return this;
    }


    public SkirtBuilder setSize(String size) {
        String trimmedSize = size.trim();

        if (!"Medium".equalsIgnoreCase(trimmedSize) && !"Large".equalsIgnoreCase(trimmedSize)) {
            throw new RuntimeException("Size must be Medium or Large");
        }

        skirts.setSize(trimmedSize);
        return this;
    }

    public SkirtBuilder setMaterial(String material) {

        String trimmedMaterial = material.trim();
        if (!"Cotton".equalsIgnoreCase(trimmedMaterial) && !"Polyester".equalsIgnoreCase(trimmedMaterial)) {
            throw new RuntimeException("Material must be Cotton or Polyester");
        }

        skirts.setMaterial(trimmedMaterial);

        return this;
    }


    public SkirtBuilder setColor(String color) {

        String trimmedColor = color.trim();
        if (!"Red".equalsIgnoreCase(trimmedColor) && !"Blue".equalsIgnoreCase(trimmedColor)) {
            throw new RuntimeException("Color must be Red or Blue");
        }

        skirts.setColor(trimmedColor);
        return this;
    }


    public Skirt build() {

        boolean hasInvalidProperty = skirts.getId() == null || skirts.getId().trim().isEmpty() ||
                skirts.getSize() == null || skirts.getSize().trim().isEmpty() ||
                skirts.getMaterial() == null || skirts.getMaterial().trim().isEmpty() ||
                skirts.getColor() == null || skirts.getColor().trim().isEmpty();

        if (hasInvalidProperty) {
            throw new RuntimeException("The pants information provided is incomplete or incorrect. Please ensure all required fields are filled out correctly.");
        }



        return skirts;
    }


}
