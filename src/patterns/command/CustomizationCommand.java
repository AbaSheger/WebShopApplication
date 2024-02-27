package patterns.command;

public class CustomizationCommand implements Command {

    private Customization customization;


    public CustomizationCommand(Customization customization) {
        this.customization = customization;
    }

    @Override
    public void execute() {
     customization.apply();
    }
}
