package command_pattern.with.command.counter.command;

import java.awt.event.ActionEvent;

public interface Command {
	void execute(ActionEvent event);
	void unExecute(ActionEvent event);
}
