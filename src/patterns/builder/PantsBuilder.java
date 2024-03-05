package patterns.builder;

import models.Pants;

public class PantsBuilder {

    private Pants pants = new Pants();





    public PantsBuilder setId(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new RuntimeException("ID cannot be null or empty");
        }

        pants.setId(id);
        return this;
    }


    public PantsBuilder setPrice(double price) {


        pants.setPrice(price);
        return this;
    }

    public  PantsBuilder setSize (String size) {

        String trimmedSize = size.trim();
        if (!"Medium".equalsIgnoreCase(trimmedSize) && !"Large".equalsIgnoreCase(trimmedSize)) {
            throw new RuntimeException("Size must be Medium or Large");
        }
        pants.setSize(trimmedSize);
        return this;
    }


    public PantsBuilder  setMaterial(String material) {

        String trimmedMaterial = material.trim();
        if (!"Cotton".equalsIgnoreCase(trimmedMaterial) && !"Polyester".equalsIgnoreCase(trimmedMaterial)) {
            throw new RuntimeException("Material must be Cotton or Polyester");
        }
        pants.setMaterial(trimmedMaterial);

        return this;
    }


    public PantsBuilder setColor(String color) {

        String trimmedColor = color.trim();
        if (!"Red".equalsIgnoreCase(trimmedColor) && !"Blue".equalsIgnoreCase(trimmedColor)) {
            throw new RuntimeException("Color must be Red or Blue");
        }
        pants.setColor(trimmedColor);
        return this;
    }


    public Pants build() {

        boolean hasInvalidProperty = pants.getId() == null || pants.getId().trim().isEmpty() ||
                pants.getSize() == null || pants.getSize().trim().isEmpty() ||
                pants.getMaterial() == null || pants.getMaterial().trim().isEmpty() ||
                pants.getColor() == null || pants.getColor().trim().isEmpty();

        if (hasInvalidProperty) {
            throw new RuntimeException("The pants information provided is incomplete or incorrect. Please ensure all required fields are filled out correctly.");
        }



        return pants;
    }


}
