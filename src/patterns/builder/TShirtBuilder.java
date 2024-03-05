package patterns.builder;

import models.TShirt;

public class TShirtBuilder {


   private TShirt tshirt = new TShirt();




   //build id

    public TShirtBuilder setId(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new RuntimeException("ID cannot be null or empty");
        }

        tshirt.setId(id);
        return this;
    }

   //build price

    public TShirtBuilder setPrice(double price) {
        tshirt.setPrice(price);
        return this;
    }


    public TShirtBuilder setSize(String size) {
        String trimmedSize = size.trim();

        if (!"Medium".equalsIgnoreCase(trimmedSize) && !"Large".equalsIgnoreCase(trimmedSize)) {
            throw new RuntimeException("Size must be Medium or Large");
        }
        tshirt.setSize(trimmedSize);

        return this;
    }

    public TShirtBuilder setMaterial(String material) {

        String trimmedMaterial = material.trim();
        if (!"Cotton".equalsIgnoreCase(trimmedMaterial) && !"Polyester".equalsIgnoreCase(trimmedMaterial)) {
            throw new RuntimeException("Material must be Cotton or Polyester");
        }

        tshirt.setMaterial(trimmedMaterial);
        return this;
    }


    public TShirtBuilder setColor(String color) {
            String trimmedColor = color.trim();
            if (!"Red".equalsIgnoreCase(trimmedColor) && !"Blue".equalsIgnoreCase(trimmedColor)) {
                throw new RuntimeException("Color must be Red or Blue");
            }

            tshirt.setColor(trimmedColor);
        return this;
    }


    public TShirt build() {

        boolean hasInvalidProperty = tshirt.getId() == null || tshirt.getId().trim().isEmpty() ||
                tshirt.getSize() == null || tshirt.getSize().trim().isEmpty() ||
                tshirt.getColor() == null || tshirt.getColor().trim().isEmpty() ||
                tshirt.getMaterial() == null || tshirt.getMaterial().trim().isEmpty();

        if (hasInvalidProperty) {
            throw new RuntimeException("The T-Shirt information provided is incomplete or incorrect. Please ensure all required fields are filled out correctly.");
        }

        return tshirt;
    }


}
