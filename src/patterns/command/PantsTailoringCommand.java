package patterns.command;

import models.Pants;

public class PantsTailoringCommand implements CustomizationCommand {

    private Pants pants;
    private String fit;
    private String length;

    public PantsTailoringCommand(Pants pants, String fit, String length) {
        this.pants = pants;
        this.fit = fit;
        this.length = length;
    }
    @Override
    public void execute() {

        System.out.println("Tailoring pants to fit: " + fit);
        pants.setFit(fit); // Assuming Pants class has a setFit method
        System.out.println("Cutting pants to length: " + length);
        pants.setLength(length); // Assuming Pants class has a setLength method

    }
}
