package com.maria.dp;

import java.util.*;

public class HouseRobber {

    //House Robber I
    //pair index - sum
    public static int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

//        calcDynamic(dp, nums, nums.length - 1);
//        calcDynamic(dp, nums,nums.length - 2);

        int one = getSum(dp, nums, 0);
        int two = getSum(dp, nums, 1);

        return Math.max(one, two);
    }

    public static void calcDynamic(int[] dp, int[] nums, int index) {
        dp[index] = nums[index];
        Deque<Integer> queue = new LinkedList();
        queue.add(index);
        while (!queue.isEmpty()) {
            int curr = queue.pop();
            int p1 = curr;
            int p2 = curr;

            p1 -= 2;
            if (p1 >= 0) {
                dp[p1] = Math.max(dp[p1], nums[p1] + dp[curr]);
                if (p1 >= 2)
                    queue.addLast(p1);
            }

            p2 -= 3;
            if (p2 >= 0) {
                dp[p2] = Math.max(dp[p2], nums[p2] + dp[curr]);
                if (p2 >= 2)
                    queue.addLast(p2);
            }

        }
    }

    public static int getSum(int[] dp, int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] >= 0) {
            return dp[index];
        }
        int sum1 = nums[index] + getSum(dp, nums, index + 2);
        int sum2 = nums[index] + getSum(dp, nums, index + 3);
        dp[index] = Math.max(sum1, sum2);
        return dp[index];
    }

    //House Robber II
    public static int robII(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<dp.length;i++)
        {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
