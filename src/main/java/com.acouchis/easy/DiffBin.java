package com.acouchis.easy;

/**
 * Created by gaopeng09 on 2020-01-16
 */
public class DiffBin {
    public boolean hasAlternatingBits(int n) {
        boolean b;
        b = (n & 0x1) == 1;
        while ((n = n >> 1) > 0) {
            boolean b1;
            b1 = (n & 0x1) == 1;
            if (b == b1) {
                return false;
            }

            b = b1;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new DiffBin().hasAlternatingBits(5));
    }
}
