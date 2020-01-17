package com.acouchis.middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 未提交成功
 * 最后两个case超时
 *
 *
 * Created by gaopeng09 on 2020-01-16
 */
public class JudgePali {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {


        Map<String, Integer> succ = new HashMap<>();


        LinkedList<Boolean> result = new LinkedList<>();
        for (int[] is : queries) {
            int left = is[0];
            int right = is[1];
            int repNum = is[2];

            CharSequence charSequence = s.subSequence(left, right + 1);
            if ((charSequence.length() & 0x1) == 1) {
                repNum++;
            }

            if (succ.getOrDefault(left+":"+right,repNum+1)<repNum){
                result.add(true);
                continue;
            }

            ReduceMap collect = new ReduceMap();

            charSequence.chars().forEach(collect::put);


            succ.put(left + ":" + right, (int) Math.ceil(collect.size() / 2D));
            if (collect.size() == 0 || Math.ceil(collect.size() / 2D) <= repNum) {
                result.add(true);
            } else {

                result.add(false);
            }
        }


        return result;
    }

    class ReduceMap {
        private int[] ints = new int[26];
        private int size = 0;

        public void put(int key) {
            key = key - 'a';
            if (ints[key] == 1) {
                ints[key] = 0;
                size--;
            } else {
                ints[key] = 1;
                size++;
            }
        }

        public int size() {
            return size;
        }


    }

    public static void main(String[] args) {
        System.out.println(new JudgePali().canMakePaliQueries("hunu", new int[][]{{0, 3, 1}}));
    }
}
