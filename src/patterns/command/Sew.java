package patterns.command;

public class Sew implements Customization {
    private String alterationType;
    private String details;

    public Sew(String alterationType, String details) {
        this.alterationType = alterationType;
        this.details = details;

    }

    @Override
    public void apply() {
        System.out.println("Sewing for " + alterationType + " with details: " + details);
        // Actual sewing logic would go here, such as altering the garment's structure or fitting
    }

}