package com.maria.arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int fp = 0, sp = 0;
        while (fp < nums.length && nums[fp] != 0) {
            fp++;
            sp++;
        }
        if (fp > nums.length) return;
        while (sp < nums.length) {
            if (nums[sp] != 0) {
                nums[fp] = nums[sp];
                nums[sp] = 0;
                while (fp < nums.length && nums[fp] != 0) {
                    fp++;
                }
            }
            sp++;
        }
    }

    public static void moveZeroes2(int[] nums) {

        int fp = 0, sp = nums.length - 1;
        while (sp >= 0 && nums[sp] == 0) {
            sp--;
        }
        if (sp < 0) return;
        while (fp <= sp) {

            if (nums[fp] == 0) {
                nums[fp] = nums[sp];
                nums[sp] = 0;
                while (sp >= 0 && nums[sp] == 0) {
                    sp--;
                }
            }
            fp++;
        }
    }
}
