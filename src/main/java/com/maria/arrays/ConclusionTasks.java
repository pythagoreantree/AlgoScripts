package com.maria.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConclusionTasks {

    public static int heightChecker(int[] heights) {
        int length = heights.length;
        int[] expected = Arrays.copyOf(heights, length);
        Arrays.sort(expected);

        int diff = 0;
        for (int i = 0; i < length; i++){
            if (heights[i] != expected[i]){
                diff++;
            }
        }
        return diff;
    }

    public static int thirdMax(int[] nums) {
        double minusInf = (-1)*Math.pow(2, 31) - 1;
        double f = minusInf;
        double s = minusInf;
        double t = minusInf;

        int k = nums.length;
        //here exception case if l <= 2
        if (k <= 2){
            double loc_max = f;
            for (int j=0; j<k; j++){
                if (nums[j] > loc_max){
                    loc_max = nums[j];
                }
            }
            return Double.valueOf(loc_max).intValue();
        }

        for (int i=0; i<k; i++){
            if (nums[i] > f){
                t = s;
                s = f;
                f = nums[i];
            } else if (nums[i] > s && nums[i] != f){
                t = s;
                s = nums[i];
            } else if (nums[i] > t && nums[i] != f && nums[i] != s){
                t = nums[i];
            }
        }

        if (Double.valueOf(t).equals(minusInf)){
            return Double.valueOf(f).intValue();
        } else {
            return Double.valueOf(t).intValue();
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 1 && nums[0] != 1){
            return new ArrayList<Integer>();
        }
        int ind = 0;
        int val = 0;
        for (int i = 0; i < nums.length; i++){
            while ((nums[i] != (i + 1)) && nums[i] != -1){
                ind = nums[i] - 1;
                val = nums[ind];
                if (nums[i] == val && (nums[ind] == (ind + 1))){
                    nums[i] = -1;
                } else {
                    nums[ind] = nums[i];
                    nums[i] = val;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++){
            if (nums[j] == -1){
                ans.add(j+1);
            }
        }
        return ans;
    }

    public static int[] sortedSquares(int[] nums) {
        int[] newNums = new int[nums.length];

        //here exceptions if just two or less elems
        int i = 0;
        while ((i+1)<nums.length && Math.abs(nums[i]) >= Math.abs(nums[i+1])){
            i++;
        }
        int middle = i;
        int fp = middle - 1;
        int sp = middle + 1;

        int j = 0;
        newNums[j++] = nums[middle]*nums[middle];
        while (0 <= fp && sp < nums.length){
            if (Math.abs(nums[fp]) < Math.abs(nums[sp])){
                newNums[j++] = nums[fp]*nums[fp];
                fp--;
            } else if (Math.abs(nums[fp]) > Math.abs(nums[sp])){
                newNums[j++] = nums[sp]*nums[sp];
                sp++;
            } else {
                newNums[j++] = nums[fp]*nums[fp];
                newNums[j++] = nums[sp]*nums[sp];
                fp--;
                sp++;
            }
        }
        while (0 <= fp){
            newNums[j++] = nums[fp]*nums[fp];
            fp--;
        }
        while (sp < nums.length){
            newNums[j++] = nums[sp]*nums[sp];
            sp++;
        }

        return newNums;
    }
}
