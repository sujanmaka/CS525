package command_pattern_counter.command;


import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    List<Command> commandList = new ArrayList<>();
    List<Command> unDoList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void undo(){
        if (!commandList.isEmpty()){
            Command c = commandList.get(commandList.size() -1);
            c.unExecute();
            commandList.remove(c);
            unDoList.add(c);
        }
    }

    public void redo(){
        if(!unDoList.isEmpty()){
            Command c = unDoList.get(unDoList.size() -1);
            c.execute();
            unDoList.remove(c);
            commandList.add(c);
        }
    }
}
