package src.presenter;

import src.model.member.Gender;
import src.model.member.Human;
import src.model.service.Service;
import src.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void printTree() {
        view.print(service.printTree());
    }

    public void addMember(String name, String surname, Gender gender, String dateBirth, Human father, Human mother) {
        service.addHuman(name, surname, gender, dateBirth, father, mother);
    }

    public Human searchMemberByName(String name) {
        return service.searchMemberByName(name);
    }

    public void clearTree() {
        service.clearTree();
    }

    public void loadTree(String fileName) {
        service.load(fileName);
    }

    public void saveTree(String fileName) {
        service.save(fileName);
    }

    public void removeMember(String name) {
        service.removeMember(name);
    }
}
