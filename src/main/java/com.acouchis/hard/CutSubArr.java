package com.acouchis.hard;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by gaopeng09 on 2020-01-29
 */
public class CutSubArr {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        return Arrays.stream(nums).boxed().reduce(new HashMap<Integer, Integer>(), (r, n) -> {
            r.compute(n, (k, ov) -> ov == null ? 1 : ov + 1);
            return r;
        }, (r1, r2) -> {
            throw new RuntimeException();
        }).values().stream().sorted((v1, v2) -> Integer.compare(v2, v1)).limit(1).anyMatch(t -> t * K <= nums.length);
    }


}
