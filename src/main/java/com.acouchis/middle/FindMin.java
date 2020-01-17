package com.acouchis.middle;

/**
 * Created by gaopeng09 on 2020-01-16
 */
public class FindMin {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        do {

            if (nums.length < 2||right-left<2) {
                return Math.min(nums[0], Math.min(nums[left], nums[right ]));
            }
            int idx = (right + left) / 2;

            if (nums[idx] == nums[left] || nums[idx] == nums[nums.length - 1]) {
                int[] lDG = new int[idx];
                int[] rDG = new int[nums.length - idx];

                System.arraycopy(nums, 0, lDG, 0, idx);


                System.arraycopy(nums, idx, rDG, 0, nums.length - idx);


                return Math.min(findMin(lDG), findMin(rDG));
            }

            if (nums[idx] > nums[0]) {
                left = idx;
            } else {
                right = idx;
            }

        } while (true);
    }
}
