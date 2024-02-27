package patterns.command;

public class PackageCommand {
    private Command command;
    private String label;
    public PackageCommand(Command command, String label) {
        this.command = command;
        this.label = label;
    }
    public void execute() {
        System.out.println(label);
        command.execute();
    }
}
