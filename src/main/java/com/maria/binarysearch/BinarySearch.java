package com.maria.binarysearch;

import com.maria.Main;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    /*
     * Binary Search Templates Section
     * */
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }

    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left != nums.length && nums[left] == target)
            return left;
        return -1;
    }

    public static int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left + 1 == right
        if (nums[left] == target)
            return left;
        if (nums[right] == target)
            return right;
        return -1;
    }

    public static int search4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //if not found return first greater
        return left;
    }

    /*
     * mySqrt Section
     * */
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;

        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right;
    }

    /*
     * Guess Number Section
     * */
    public static int guess(int n) {
        int g = 1;
        if (n == g)
            return 0;
        else if (n < g)
            return 1;
        else
            return -1;
    }

    public static int guessNumber(int n) {
        int l = 1, r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (guess(m) == 0)
                return m;
            else if (guess(m) == 1)
                l = m + 1;
            else
                r = m - 1;
        }

        return r;
    }

    /*
     * Search Pivoted Array Section
     * */
    public static int searchNonSortedArray(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            else if (target < nums[m]) {
                if (target == nums[l])
                    return l;

                if (target > nums[l]) {
                    r = m - 1;
                } else {
                    if (nums[l] <= nums[m])
                        l = m + 1;
                    else
                        r = m - 1;
                }

            } else if (target > nums[m]) {
                if (target == nums[r])
                    return r;
                //                l = m + 1;
                if (target < nums[r])
                    l = m + 1;
                else {
                    if (nums[m] < nums[r])
                        r = m - 1;
                    else {
                        l = m + 1;
                    }
                }
            }

        }
        return -1;
    }

    /*
     * G4G Binary Search Pivoted Array Section
     * */
    /* Java program to search an element in a sorted and pivoted array*/
    /* Searches an element key in a pivoted sorted array arr[] of size n */
    public static int pivotedBinarySearch(int arr[], int n, int key) {
        int pivot = findPivot(arr, 0, n - 1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    /* Function to get pivot. For array
    3, 4, 5, 6, 1, 2 it returns
    3 (index of 6) */
    public static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function */
    public static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    /*
     * Search Rotated Array Section
     * */
    public static int searchRotated(int arr[], int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[low] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[low] && key <= arr[mid])
                return searchRotated(arr, low, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return searchRotated(arr, mid + 1, high, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[high])
            return searchRotated(arr, mid + 1, high, key);

        return searchRotated(arr, low, mid - 1, key);
    }

    /*
     * Find First Bad Version Section
     * */
    public static boolean isBadVersion(int n) {
        return false;
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == right && isBadVersion(left))
            return left;
        return -1;
    }

    /*
     * Find Peak Element Section
     * */
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static int findPeakElementT3V1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m - 1] <= nums[m]) {
                l = m;
            } else if (nums[m - 1] > nums[m]) {
                r = m;
            }
        }
        if (nums.length == 1 || nums[l] > nums[l + 1])
            return l;
        if (r == nums.length - 1 && (nums[r - 1] < nums[r]))
            return r;
        return -1;
    }

    public static int findPeakElementT3V2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m - 1] < nums[m] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m - 1] <= nums[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[l] > nums[r]) {
            return l;
        } else {
            return r;
        }
    }

    public static int findPeakElementT3V3(int[] nums) {
        if (nums.length == 0)
            return -1;

        if (nums.length == 1)
            return 0;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
                return mid;
            else if (nums[mid] < nums[mid + 1])
                left = mid;
            else
                right = mid;
        }

        if (nums[left] > nums[left + 1])
            return left;
        if (nums[right] > nums[right - 1])
            return right;
        return -1;
    }

    /*
     * Find Min in Rotated Array Section
     * */
    public static int findMinInRotatedArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[0] && nums[0] > nums[nums.length - 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    //    public static int findMin(int[] nums) {
    //        int left = 0, right = nums.length - 1;
    //        while (left < right) {
    //            int mid = left + (right - left) / 2;
    //
    //            if(nums[mid] < nums[right]) {
    //                right = mid;
    //            } else {
    //                left = mid+1;
    //            }
    //        }
    //        return nums[left];
    //    }

    /*
     * Search Range Section
     * */
    public static int searchL(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left != nums.length && nums[left] == target)
            return left;
        return -1;
    }

    public static int searchR(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && ((mid + 1) == nums.length || nums[mid + 1] > target)) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left != nums.length && nums[left] == target)
            return left;
        return -1;
    }

    public static int[] searchLR(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = searchL(nums, target);
        res[1] = searchR(nums, target);
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = searchFirstLastElement(nums, target, true);
        if (res[0] == -1)
            return res;
        res[1] = searchFirstLastElement(nums, target, false);
        return res;
    }

    public static int searchFirstLastElement(int[] nums, int target, boolean isFirst) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (isFirst) {
            if (nums[left] == target)
                return left;
            else if (nums[right] == target)
                return right;
        } else {
            if (nums[right] == target)
                return right;
            else if (nums[left] == target)
                return left;
        }
        return -1;
    }

    /*public static int searchRight(int[] nums, int target){
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;

        return -1;
    }*/

    /*
     * Find K Closest Elements Section
     */
    public static List<Integer> findKClosestElements(int[] nums, int k, int x) {
        ArrayList<Integer> alist = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0)
            return alist;

        int left = 0, right = nums.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //            if (x - nums[mid] > nums[mid+k] - x){
            if (p(nums[mid], x) == p(nums[mid + k], x)) {
                if (nums[mid] <= x && x <= nums[mid + k]) {
                    right = mid;
                } else if (x <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (p(nums[mid], x) > p(nums[mid + k], x)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //        Main.print("Left: " + left);
        //        Main.print("Right: " + right);
        for (int i = left; i < (left + k); i++) {
            alist.add(nums[i]);
        }

        return alist;
    }

    public static int p(int a, int b) {
        return Math.abs(a - b);
    }

    public static boolean isCloser(int a, int b, int x) {
        return (Math.abs(a - x) < Math.abs(b - x)) || (Math.abs(a - x) == Math.abs(b - x) && a < b);
    }

    //Bad solution
    public static List<Integer> findKClosest(int[] nums, int k, int x) {
        ArrayList<Integer> alist = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0)
            return alist;

        int left = 0, right = nums.length - 1;
        int index = search4(nums, x);

        int leftDist = p(nums[left], nums[index]);
        int rightDist = p(nums[right], nums[index]);
        //        int leftNum = index - left;
        //        int rightNum = right - index + 1 ;
        //        int num = leftNum + rightNum;

        while (right - left + 1 > k) {
            int m1 = left + (index - left) / 2;
            int m2 = index + (right - index) / 2;
            if (m2 - m1 + 1 >= k) {
                if (leftDist > p(nums[m1], nums[index])) {
                    left = m1;
                }
                if (rightDist > p(nums[m2], nums[index])) {
                    right = m2;
                }
            } else {
                if (rightDist > p(nums[m2], nums[index])) {
                    right = m2;
                }
            }
        }

        //        Main.print("Left: " + left);
        //        Main.print("Right: " + right);
        for (int i = left; i <= right; i++) {
            alist.add(nums[i]);
        }

        return alist;
    }

    /*
     * Pow(x, n) Section
     * */
    public static double myPow(double x, int n) {
        double temp;
        if (n == 0)
            return 1;
        temp = myPow(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else {
            if (n > 0)
                return x * temp * temp;
            else
                return temp * temp * (1 / x);
        }
    }


    //O(n)
    public static int power(int x, int y) {
        if (y == 0)
            return 1;
        else if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        else
            return x * power(x, y / 2) * power(x, y / 2);
    }

    /*
     * Valid Perfect Square
     * */
    public static boolean isPerfectSquare(int num) {
        if (num == 0)
            return true;

        int l = 1, r = num / 2;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == num / m && num % m == 0) {
                return true;
            } else if (m <= num / m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (l * l == num || r * r == num)
            return true;
        return false;
    }

    /*
     * Find Smallest Letter Greater Than Target
     * */
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;

        if (target >= letters[r]) {
            return letters[l];
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return letters[r];
    }

    /*
    * Find Min in Rotated Array 2
    * */
    public static int findMinInRotatedArray2(int[] nums) {
        int l = 0, r = nums.length - 1;

        if (nums[l] <= nums[r])
            return nums[l];

        while (l + 1 < r){
            int m = l + (r - l) / 2;
            if (nums[l] < nums[m]){
                l = m;
            } else if (nums[l] > nums[m]){
                r = m;
            }
        }

        if (nums[l] > nums[r]) return nums[r];
        return -1;
    }

    /*
    * Rotated Array may have duplicates
    * */
    public static int findMinInRotatedArrayWithDuplicates(int[] nums) {
        int l = 0, r = nums.length - 1;

        if (l == r)
            return nums[l];

        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[l] < nums[m] && nums[l] < nums[r]){
                return nums[l];
            } else if (nums[l] == nums[m] && nums[l] == nums[r]) {
                int d = whichDirection(nums, m);
                switch(d){
                    case 0:
                    case -2:
                    case 2:
                        return nums[m];
                    case -1:
                        r = m;
                        break;
                    case 1:
                        l = m + 1;
                        break;
                }
            } else if (nums[l] <= nums[m] && nums[l] >= nums[r]){
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l == r) return nums[l];
        return -1;
    }

    private static int whichDirection(int[] nums, int middle){
        int fp = middle;
        int sp = middle;
        int middleValue = nums[middle];
        while (fp != 0 && sp != nums.length &&
                nums[fp] == middleValue && nums[sp] == middleValue){
            fp--;
            sp++;
        }
        if(nums[fp] != middleValue && nums[fp] < middleValue) return -1;
        if(nums[fp] != middleValue && nums[fp] > middleValue) return -2;
        if(nums[sp] != middleValue && nums[sp] < middleValue) return 1;
        if(nums[sp] != middleValue && nums[sp] > middleValue) return 2;
        return 0;
    }

    public static int findMinInRotatedArrayWithDuplicates2(int[] nums){
        int l= 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r-l)/2;
            if(nums[m] > nums[r])
                l = m + 1;
            else if(nums[m] < nums[r])
                r = m;
            else {
                r--;
            }
        }
        return nums[l];
    }
    /*
     * Rubbish Section with comments and some intermediate code/solutions
     * */
    //        if (x < nums[0]){
    //            int end = k < nums.length? k: nums.length;
    //            for(int i = 0; i<end; i++){
    //                alist.add(nums[i]);
    //            }
    //            return alist;
    //        } else if (x > nums[nums.length-1]){
    //            int start = k < nums.length? nums.length - k: 0;
    //            for(int i = start; i<nums.length; i++){
    //                alist.add(nums[i]);
    //            }
    //            return alist;
    //        }
    //
    //        if (nums[mid] < x && p(nums[left], x) > p(nums[mid], x)){
    //            left = mid;
    //        } else if (nums[mid] > x && p(nums[right], x) > p(nums[mid], x)){
    //            right = mid;
    //        } else {
    //            //we are into the range. what we gonna do?
    //            if (nums[mid] == x){
    //                right = mid;
    //            } else if(nums[mid] < x){
    //                left = mid;
    //            }
    //        }

}
