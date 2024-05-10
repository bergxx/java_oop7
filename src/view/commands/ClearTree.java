package src.view.commands;

import src.view.ConsoleUI;

public class ClearTree extends Command{
    public ClearTree(ConsoleUI console) {
        super(console);
        description = "Очистить дерево \n";
    }
    @Override
    public void execute() {
        console.clearTree();
    }
}
