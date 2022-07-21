package main.java;

import java.util.Comparator;
import java.util.Map;

class MyComparator implements Comparator<Object> {

    Map<String, Integer> map;

    public MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {

        if (map.get(o2) == map.get(o1))
            return ((String) o1).compareTo((String) o2);
        else
            return (map.get(o2)).compareTo(
                    map.get(o1));

    }
}