package com.acouchis.easy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution0 {
    public boolean isAnagram(String s, String t) {
        Map<Integer, List<Integer>> collect = t.chars().boxed().collect(Collectors.groupingBy(ts -> ts));

        try {
            s.chars().boxed().reduce(collect, (Map<Integer,
                    List<Integer>> l, Integer r) -> {
                List<Integer> integers = l.get(r);
                boolean remove = integers.remove(r);
                if (!remove) {
                    throw new RuntimeException();
                }

                return l;
            }, (ll, rr) -> rr);
            for (List<Integer> integers : collect.values()) {
                if (integers != null && !integers.isEmpty()) {
                    throw new RuntimeException();
                }
            }
        } catch (Exception e) {
            return false;
        }


        return true;
    }
}