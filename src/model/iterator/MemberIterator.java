package src.model.iterator;

import java.util.*;

public class MemberIterator<T> implements Iterator<T> {

    private int index;
    private final List<T> members;

    public MemberIterator(List<T> members) {
        this.members = members;

    }
    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public T next() {
        return members.get(index++);
    }
}
