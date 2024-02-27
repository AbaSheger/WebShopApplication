package patterns.command;

public class Cut implements Customization  {

    private String garmentPart;
    private  int newLength;


    @Override
    public void apply() {
        System.out.println("Cutting " + garmentPart + " to " + newLength + " cm");

        // Here, you'd have logic to actually modify the garment object, e.g., adjusting its length attribute

    }
}
