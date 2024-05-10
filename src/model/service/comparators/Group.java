package src.model.service.comparators;

import java.util.List;

public interface Group<T> extends Iterable<T> {
    boolean add(T member);
    boolean remove(T member);

    List<T> getMembers();
    String getInfo();
}
