package patterns.command;

public class Decorate implements Customization {

    private String decorationType;
    private String decorationDetails;

    public Decorate(String decorationType, String decorationDetials) {
        this.decorationType = decorationType;
        this.decorationDetails = decorationDetials;
    }


    @Override
    public void apply() {
        System.out.println("Adding " + decorationType + ": " + decorationDetails);
        // Here, implement the logic to add the decoration to the garment, e.g., setting a pattern or color attribute
    }
}
