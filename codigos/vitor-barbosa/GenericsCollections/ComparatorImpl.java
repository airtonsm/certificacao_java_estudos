package estudos.ocp.GenericsCollections;

import java.util.Comparator;

public class ComparatorImpl implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
