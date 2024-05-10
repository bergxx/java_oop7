package src.model.service.comparators;

import java.util.Comparator;

import src.model.member.Human;

public class MemberComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
