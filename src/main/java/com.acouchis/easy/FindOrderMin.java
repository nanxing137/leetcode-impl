package com.acouchis.easy;

/**
 * Created by gaopeng09 on 2020-01-28
 */
public class FindOrderMin {
    public char nextGreatestLetter(char[] letters, char target) {

        int gap = Integer.MAX_VALUE;
        int idx = 0;


        for (int i = 0; i < letters.length; i++) {
            int gapT = letters[i] - target;
            if (gapT > 0 && gapT < gap) {
                idx = i;
                gap = gapT;
                if (gap == 1) {
                    break;
                }
            }


        }


        return letters[idx];
    }
}
