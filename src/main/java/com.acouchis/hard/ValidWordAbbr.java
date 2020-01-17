package com.acouchis.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {
    private Set<String> dic = new HashSet<>();

    public ValidWordAbbr(String[] dictionary) {

        Arrays.stream(dictionary).forEach(t -> {
            System.out.println(getS(t));
            dic.add(getS(t));
        });
    }

    public boolean isUnique(String word) {
        System.out.println(getS(word));
        return !dic.contains(getS(word));
    }

    private String getS(String input) {
        if (input.length() > 2) {
            return input.charAt(0) + "" + (input.length() - 2) + input.charAt(input.length() - 1);
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidWordAbbr(new String[]{"vdsfsdfsdr", "udsfsdfe"}).isUnique("hello"));
    }
}