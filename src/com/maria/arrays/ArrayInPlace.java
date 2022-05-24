package com.maria.arrays;

public class ArrayInPlace {

    public static int[] replaceElements(int[] arr) {
        if (arr.length == 1){
            arr[0] = -1;
            return arr;
        }

        int lastIndex = arr.length-1;
        int maxElem = arr[lastIndex];
        for (int i = lastIndex-1; i >= 0; i--){
            int currentElem = arr[i];
            arr[i] = maxElem;
            if (currentElem > maxElem){
                maxElem = currentElem;
            }
        }

        arr[lastIndex] = -1;

        return arr;
    }

    public static int removeDuplicatesLinear(int[] nums) {
        int length = nums.length;
        if (nums.length == 0){
            return 0;
        }
        int counter = 1;
        int pointer = 1;
        for (int i = 1; i < length; i++){
            //changed or not changed
            if (nums[i] != nums[i-1]){
                if (counter > 1 || i != pointer){
                    nums[pointer] = nums[i];
                    counter = 1;
                }
                pointer++;
            } else {
                counter++;
            }
        }
        return pointer;
    }

    public static void moveZeroes(int[] nums) {
        int pointer = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        while (pointer != nums.length){
            nums[pointer] = 0;
            pointer++;
        }
    }

    public static int[] sortArrayByParity(int[] nums) {
        int odd_pointer = -1;

        int i = 0;
        while (i < nums.length && nums[i] % 2 == 0){
            i++;
        }
        if (i == nums.length){
            return nums;
        }
        odd_pointer = i;
//        Main.print(odd_pointer);
        for (int j = odd_pointer; j < nums.length; j++){
            if (nums[j] % 2 == 0){
                int k = nums[odd_pointer];
                nums[odd_pointer] = nums[j];
                nums[j] = k;
                odd_pointer++;
            }
        }
        return nums;
    }


    public static int removeElement(int[] nums, int val) {
        int pointer = 0;

        for (int i=0; i<nums.length; i++){
            if (nums[i] != val){
                nums[pointer] = nums[i];
                pointer++;
            }
        }

        return pointer;
    }
}
