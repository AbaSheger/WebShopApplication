package patterns.command;

public class LabelCommand {
    private Command command;
    private String label;
    public LabelCommand(Command command, String label) {
        this.command = command;
        this.label = label;
    }
    public void execute() {
        System.out.println(label);
        command.execute();
    }
}
