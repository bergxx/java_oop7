package src;
import src.model.familyTree.FamilyTree;
import src.model.member.Human;
import src.model.service.Service;
import src.presenter.Presenter;
import src.view.ConsoleUI;
import src.view.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        FamilyTree<Human> tree = new FamilyTree<>();
        Service service = new Service(tree);
        new Presenter(view, service);
        view.start();
    }
}
