package src.view.commands;

import src.view.ConsoleUI;

public class AddMember extends Command{
    public AddMember(ConsoleUI console) {
        super(console);
        description = "Добавить элемент к дереву \n";
    }
    @Override
    public void execute() {
        console.addMember();
    }
}
