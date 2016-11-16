package com.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String args[]) {
        String name = "Bhanu Kishore Kishore";
        System.out.println(countUniqueWordUsingMap(name));
        System.out.println(countUniqueWordUsingSet(name));
    }

    private static int countUniqueWordUsingMap(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            map.put(word, 1);
        }

        System.out.println(map);

        return map.keySet().size();
    }

    private static int countUniqueWordUsingSet(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            set.add(word);
        }

        System.out.println(set);

        return set.size();
    }
}
