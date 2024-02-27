package patterns.command;

public class DecorateCommand {
    private Command command;
    public DecorateCommand(Command command) {
        this.command = command;
    }
    public void execute() {
        command.execute();
    }
}
