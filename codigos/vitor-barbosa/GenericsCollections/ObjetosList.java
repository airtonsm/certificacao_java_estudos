package estudos.ocp.GenericsCollections;

import java.lang.reflect.Array;
import java.util.*;

public class ObjetosList{

    public static void main(String[] args) {
        ComparatorImpl comparator = new ComparatorImpl();
        String[] string = {"teste", "com","metodos", "de", "list"};
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet();
        TreeMap treeMap = new TreeMap();
        ArrayDeque arrayDeque = new ArrayDeque();


        arrayList.addAll(Arrays.asList(string));
        System.out.println(arrayList.get(0));
        System.out.println();
        System.out.println(arrayList.size());
        System.out.println();
        arrayList.sort(comparator);
        System.out.println(arrayList);



    }
}
