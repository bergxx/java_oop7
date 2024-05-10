package src.model.service.comparators;

import java.util.Comparator;

import src.model.member.Human;

public class IdComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
