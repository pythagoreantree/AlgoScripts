package com.maria.dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    public static Map<Integer, Boolean> dp = new HashMap<>();
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return true;
        return f(0, nums);
    }

    private static boolean f(int index, int[] nums) {
        if (index < (nums.length-1) && nums[Integer.valueOf(index)] == 0) {
            dp.put(index, false);
            return false;
        }
        if (index == (nums.length-1)) {
            dp.put(index, true);
            return true;
        }
        if (index >= nums.length) {
            return false;
        }


        boolean init = false;
        for (int i = nums[index]; i >= 1; i--){
            if ((index + i) > nums.length) {
                continue;
            }
            boolean cond = dp.containsKey(index + i) ? dp.get(index + i) : f(index + i, nums);
            if (cond) {
                init = true;
                break;
            }
        }
        dp.put(index, init);
        return dp.get(index);
    }


    /*public static boolean canJumpIIIint[] nums) {
        if (nums == null || nums.length <= 1)
            return true;

        for (int i: nums) {
            if (i == 0) return false;
        }
        return true;
    }*/

    public static boolean canJumpII(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

    public static boolean canJumpIII(int[] nums) {
        int n = nums.length;
        int reachable = 0;
        for (int i = 0; i < n; i++){
            if (i > reachable) {
                return false;
            }
            if (reachable >= n) {
                return true;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;

    }
}
