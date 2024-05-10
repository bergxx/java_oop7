package src.view.commands;

import src.view.ConsoleUI;

public class PrintTree extends Command{

    public PrintTree(ConsoleUI console) {
        super(console);
        description = "Показать все элементы дерева \n";
    }
    @Override
    public void execute() {
        console.printTree();
    }
}
