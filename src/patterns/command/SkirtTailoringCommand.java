package patterns.command;

import models.Skirt;

public class SkirtTailoringCommand implements CustomizationCommand {

    private Skirt skirt;
    private String waistline;
    private String pattern;

    public SkirtTailoringCommand(Skirt skirt, String waistline, String pattern) {
        this.skirt = skirt;
        this.waistline = waistline;
        this.pattern = pattern;
    }
    @Override
    public void execute() {
        System.out.println("Tailoring Skirt to waistline: " + waistline);
        skirt.setWaistline(waistline); // Assuming Skirt class has a setWaistline method
        System.out.println("Applying pattern to Skirt: " + pattern);
        skirt.setPattern(pattern); // Assuming Skirt class has a setPattern method
    }
}
