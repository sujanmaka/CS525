package command_pattern.with.command.counter.command;


import command_pattern.with.command.counter.Counter;

import java.awt.event.ActionEvent;

public class IncrementCommand implements Command {

    private Counter counter;

    public IncrementCommand(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void execute(ActionEvent event) {
        counter.jButtonIncrement_actionPerformed(event);
    }

    @Override
    public void unExecute(ActionEvent event) {
        counter.jButtondecrement_actionPerformed(event);
    }
}
