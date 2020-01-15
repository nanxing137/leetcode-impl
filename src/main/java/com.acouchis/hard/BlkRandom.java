package com.acouchis.hard;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gaopeng09 on 2020-01-15
 */
public class BlkRandom {

    private Random random = new Random();
    private List<Integer> white;
    private boolean type;
    private Set<Integer> set;
    private int n;


    public BlkRandom(int N, int[] blacklist) {


        if (blacklist.length < (N >> 2)) {
            type = true;
            set = IntStream.of(blacklist).boxed().collect(Collectors.toSet());
            n = N;
            return;
        }
        Arrays.sort(blacklist);
        if (blacklist.length == 0) {
            white = IntStream.range(0, N).boxed().collect(Collectors.toList());
            return;
        }


        white = new ArrayList<>();
        List<Integer> s1 = IntStream.range(0, blacklist[0]).boxed().collect(Collectors.toList());
        if (!s1.isEmpty() && blacklist[0] != 0) {
            white.addAll(s1);
        }

        for (int i = 0; i < blacklist.length; i++) {

            if (i + 1 >= blacklist.length) {

                white.addAll(IntStream.range(blacklist[i] + 1, N).boxed().collect(Collectors.toList()));
                break;
            } else if (blacklist[i] != blacklist[i + 1] - 1) {
                white.addAll(IntStream.range(blacklist[i] + 1, blacklist[i + 1]).boxed().collect(Collectors.toList()));
            }
        }


    }

    public int pick() {
        if (type) {
            int i;
            while ((true)) {
                if (!set.contains(i = random.nextInt(n))) {
                    return i;
                }
            }
        }
        return white.get(random.nextInt(white.size()));
    }

    public static void main(String[] args) {
        BlkRandom blkRandom = new BlkRandom(1, new int[]{});
        System.out.println(blkRandom.pick());
        System.out.println(blkRandom.pick());
        System.out.println(blkRandom.pick());
        System.out.println(blkRandom.pick());
        System.out.println(blkRandom.pick());
    }
}
