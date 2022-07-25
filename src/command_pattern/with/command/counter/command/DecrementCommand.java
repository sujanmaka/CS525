package command_pattern.with.command.counter.command;


import command_pattern.with.command.counter.Counter;

import java.awt.event.ActionEvent;

public class DecrementCommand implements Command {

    private Counter counter;

    public DecrementCommand(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void execute(ActionEvent event) {
        counter.jButtondecrement_actionPerformed(event);
    }

    @Override
    public void unExecute(ActionEvent event) {
        counter.jButtonIncrement_actionPerformed(event);
    }
}
