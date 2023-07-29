package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            boolean found = true;
            for (String string : strings) {
                if (!string.matches("^[A-Z].*")) {
                    found = false;
                    break;
                }
            }
            return found;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return values -> {
            int size = values.size();
            for (int i = 0; i < size; i++) {
                Integer current = values.get(i);
                if (current % 2 == 0) {
                    values.add(current);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            ArrayList<String> list = new ArrayList<>();

            for (String value : values) {
                if (value.matches("^[A-Z].[A-Za-z]*(?: [A-Za-z]+){3,}\\.")) {
                    list.add(value);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            HashMap<String, Integer> map = new HashMap<>();

            for (String string : strings) {
                map.put(string, string.length());
            }

            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (first, second) -> {
            ArrayList<Integer> list = new ArrayList<>(first);
            list.addAll(second);
            return list;
        };
    }
}
