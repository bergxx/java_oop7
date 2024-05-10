package src.view.commands;

import src.view.ConsoleUI;

public class SearchMember extends Command{
    public SearchMember(ConsoleUI console) {
        super(console);
        description = "Поиск элемента дерева \n";
    }
    @Override
    public void execute() {
        console.searchMemberByName();
    }
}
