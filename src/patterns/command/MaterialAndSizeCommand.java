package patterns.command;
// Handles both selecting material and choosing size
public class MaterialAndSizeCommand implements CustomizationCommand {

    private Clothing clothing;
    private String material;
    private String size;

    public MaterialAndSizeCommand(Clothing clothing, String material, String size) {
        this.clothing = clothing;
        this.material = material;
        this.size = size;
    }

    @Override
    public void execute() {
        clothing.setMaterial(material);
        System.out.println("Material set to " + material);
        clothing.setSize(size);
        System.out.println("Size set to " + size);
    }
}


