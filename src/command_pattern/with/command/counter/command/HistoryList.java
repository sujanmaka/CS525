package command_pattern.with.command.counter.command;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {
	private Collection<Command> commandlist = new ArrayList<Command>();
	private Collection<Command> undolist = new ArrayList<Command>();

	public void undo(ActionEvent event) {
		if (commandlist.size() > 0) {
			Command commandObject = (Command) ((ArrayList<Command>) commandlist).get(commandlist.size() - 1);
			((ArrayList<Command>) commandlist).remove(commandObject);
			commandObject.unExecute(event);
			undolist.add(commandObject);
		}
	}

	public void redo(ActionEvent event) {
		if (undolist.size() > 0) {
			Command commandObject = (Command) ((ArrayList<Command>) undolist).get(undolist.size() - 1);
			commandObject.execute(event);
			((ArrayList<Command>) undolist).remove(commandObject);
			commandlist.add(commandObject);
		}
	}

	public void addCommand(Command commandObject) {
		commandlist.add(commandObject);
	}

}
