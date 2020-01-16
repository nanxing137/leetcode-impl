package com.acouchis.middle;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by gaopeng09 on 2020-01-16
 */
public class RabbitColor {
    public int numRabbits(int[] answers) {

        return IntStream.of(answers).boxed().collect(Collectors.toMap(t -> t, t -> 1, (t1, t2) -> t1 + t2)).entrySet().stream().reduce(0, (o, n) -> {
            Integer key = n.getKey();
            Integer value = n.getValue();
            key++;

            int ceil = (int) Math.ceil(value / (double) key);

            return o + ceil * key;
        }, (t1, t2) -> t1 + t2);
    }

}
