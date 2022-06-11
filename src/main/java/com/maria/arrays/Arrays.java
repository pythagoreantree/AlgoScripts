package com.maria.arrays;

public class Arrays {

    public static int findNumbers(int[] nums) {
//	    Solution solution = new Solution();

        int nums_with_even_lengths = 0;
        for (int i=0; i<nums.length; i++){
            int val = nums[i];
            int num_len = 0;
            while (val % 10 != 0 || val != 0){
                num_len += 1;
                val /= 10;
            }
            System.out.println(num_len);
            if (num_len % 2 == 0){
                nums_with_even_lengths += 1;
            }
        }
//      System.out.println(nums_with_even_lengths);
        return nums_with_even_lengths;
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int sqr = nums[i]*nums[i];
            nums[i] = sqr;
        }
        java.util.Arrays.sort(nums);
        return nums;
    }

    public static void shiftRight(int index, int[] arr){
        for (int i = arr.length-1; i > index; i--){
            arr[i] = arr[i-1];
        }
    }

    public static int[] duplicateZeros(int[] nums) {
        for (int i=0; i<(nums.length-1); i++) {
//            System.out.println("Index: " + i + ", Element:" + nums[i]);
            if (nums[i] == 0) {
                shiftRight(i, nums);
                i += 1;
            }
//            printArray(nums);
        }
        return nums;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int first_list_pointer = 0;
        for (int i = 0; i < nums2.length; i++){
            int val = nums2[i];
//            print(i + ", " + val);
//            print(Integer.valueOf(first_list_pointer).toString());
            if (n == 0)
                break;
            while (nums1[first_list_pointer] <= val && first_list_pointer < m){
                first_list_pointer += 1;
            }
            shiftRight(first_list_pointer, nums1);
            nums1[first_list_pointer] = val;
            m += 1;
//            first_list_pointer += 1;
        }
    }

    public static int shiftLeft(int index, int[] nums){
        for (int i = (index + 1); i < nums.length; i++){
            nums[i - 1] = nums[i];
        }
        return index;
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = length-1; i >= 0; i--){
            if (nums[i] == val){
                if (i == (length-1)){
                    nums[i] = 0;
                } else {
                    shiftLeft(i, nums);
                }
                length--;
            }
        }

        return length;
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (nums.length == 0){
            return 0;
        }
        int unum = nums[0];
        for (int i = 1; i < length; i++){
            int val = nums[i];
            if (val == unum){
                shiftLeft(i, nums);
                length--;
                i-=1;
            } else {
                unum = val;
            }

        }
        return length;
    }

    public static int removeDuplicates2(int[] nums) {

        // The initial length is simply the capacity.
        int length = nums.length;

        // Assume the last element is always unique.
        // Then for each element, delete it iff it is
        // the same as the one after it. Use our deletion
        // algorithm for deleting from any index.
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                // Delete the element at index i, using our standard
                // deletion algorithm we learned.
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                // Reduce the length by 1.
                length--;
            }
        }
        // Return the new length.
        return length;
    }

    public static boolean hasRelativeByTwo(int element, int[] array, int length) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (2*array[i] == element || 2*element == array[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length == 0){
            return false;
        }
        int[] itemsSeen = new int[arr.length];
        itemsSeen[0] = arr[0];
        int length = 1;
        for(int i=1; i<arr.length; i++){
            if (hasRelativeByTwo(arr[i], itemsSeen, length)){
                return true;
            }
            itemsSeen[i] = arr[i];
            length++;
        }
        return false;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3){
            return false;
        }
        int i = 1;
        while (i < arr.length && arr[i] >= arr[i-1]){
//            print(arr[i] + ',' + arr[i-1]);
            if(arr[i] == arr[i-1]){
                return false;
            }
            i++;
        }

//        print("i after first cycle: " + i);
        if (i == 1 || i == arr.length){
            return false;
        }
        while (i < arr.length){
//            print(arr[i] + "," + arr[i-1]);
            if (arr[i] >= arr[i-1]){
                return false;
            }
            i++;
        }
        return true;
    }
}
