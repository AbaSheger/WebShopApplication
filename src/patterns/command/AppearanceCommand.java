package patterns.command;

// Handles dyeing, sewing adjustments, and cutting to length in one command
public class AppearanceCommand implements CustomizationCommand{

    private Clothing clothing;
    private String color;
    private String adjustment;
    private String length;

    public AppearanceCommand(Clothing clothing, String color, String adjustment, String length) {
        this.clothing = clothing;
        this.color = color;
        this.adjustment = adjustment;
        this.length = length;
    }

    @Override
    public void execute() {
        if (color != null && !color.isEmpty()) {
            clothing.setColor(color);
            System.out.println("Color set to " + color);
        }
        if (adjustment != null && !adjustment.isEmpty()) {
            clothing.addAdjustment(adjustment);
            System.out.println("Adjustment made: " + adjustment);
        }
        if (length != null && !length.isEmpty()) {
            clothing.setLength(length);
            System.out.println("Length cut to " + length);
        }
    }

}
