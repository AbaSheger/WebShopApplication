package patterns.command;

import models.TShirt;

public class TShirtTailoringCommand implements CustomizationCommand {

    private TShirt tShirt;
    private String neckType;
    private String sleeveLength;

    public TShirtTailoringCommand(TShirt tShirt, String neckType, String sleeveLength) {
        this.tShirt = tShirt;
        this.neckType = neckType;
        this.sleeveLength = sleeveLength;
    }


    @Override
    public void execute() {
        System.out.println("Tailoring T-Shirt to neck type: " + neckType);
        tShirt.setNeckType(neckType); // Assuming TShirt class has a setNeckType method
        System.out.println("Cutting T-Shirt to sleeve length: " + sleeveLength);
        tShirt.setSleeves(sleeveLength); // Assuming TShirt class has a setSleeves method
    }
}
