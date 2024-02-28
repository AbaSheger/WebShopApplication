package patterns.command;

import java.util.ArrayList;
import java.util.List;

public class CustomizationInvoker {

    private List<CustomizationCommand> commands = new ArrayList<>();

    public void addCommand(CustomizationCommand command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (CustomizationCommand command : commands) {
            command.execute();
        }
    }

}
