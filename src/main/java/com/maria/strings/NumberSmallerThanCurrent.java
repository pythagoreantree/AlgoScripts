package com.maria.strings;

import java.util.Arrays;

public class NumberSmallerThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int[] cnts = new int[max + 1];
        for (int j = 0; j < nums.length; j++) {
            cnts[nums[j]] += 1;
        }
        int[] tmp = new int[max + 1];
        for (int k = 1; k < tmp.length; k++) {
            tmp[k] = tmp[k - 1] + cnts[k - 1];
        }
        int[] res = new int[nums.length];
        for (int l = 0; l < nums.length; l++) {
            res[l] = tmp[nums[l]];
        }
        return res;
    }
}
