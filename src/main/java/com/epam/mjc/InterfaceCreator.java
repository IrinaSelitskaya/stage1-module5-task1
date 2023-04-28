package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x-> {
            for (String s : x){
                if (Character.isUpperCase(s.charAt(0))){
                    x.remove(s);
                }
            }
        return x.isEmpty();
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x->{
            for (Integer value:x){
                if (value%2==0){
                    x.add(value);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            for (String s:values){
                if(!Character.isUpperCase(s.charAt(0)) || !s.endsWith(".") || new StringTokenizer(s).countTokens()<=3){
                    values.remove(s);
                }
            }
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String,Integer>map=new HashMap<>();
        return x->{
            for (String s:x){
                map.put(s,s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            list1.addAll(list2);
            return new ArrayList<>(list1);
        };
    }
}
