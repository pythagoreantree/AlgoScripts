package com.maria.morepractices;

import com.maria.binarysearch.BinarySearch;

import java.util.*;
import java.util.stream.Collectors;

public class Common {

    /*
     * Intersection of Two Arrays
     * */
    public static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];
        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            arr2[nums2[i]] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (arr1[i] == 1 && arr2[i] == 1)
                list.add(i);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArrays2(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int i: nums1) {
            s.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i: nums2) {
            if (s.contains(i)) {
                s.remove(i);
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        int idx = 0;
        for (Integer i: list) {
            result[idx++] = i;
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysBinSearch(int[] nums1, int[] nums2) {
        if (!(nums1.length > nums2.length)) {
            int[] numsSwap = nums1;
            nums1 = nums2;
            nums2 = numsSwap;
        }
        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();
        for (int i: nums2) {
            int pos = BinarySearch.search(nums1, i);
            if (pos != -1 && !list.contains(i))
                list.add(i);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysBruteForce(int[] nums1, int[] nums2) {
        if (!(nums1.length > nums2.length)) {
            int[] numsSwap = nums1;
            nums1 = nums2;
            nums2 = numsSwap;
        }
        //        boolean firstBigger = nums1.length > nums2.length;
        Set<Integer> s1 = arrayToSet(nums1);
        Set<Integer> s2 = arrayToSet(nums2);
        s1.retainAll(s2);
        Integer[] result = s1.toArray(new Integer[s1.size()]);
        int[] resultSimple = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            resultSimple[i] = result[i].intValue();
        }
        return resultSimple;
    }

    /*
     * Intersection of Two Arrays II
     * */
    public static int[] intersectionOfTwoArraysII(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            arr2[nums2[i]] += 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                while (arr1[i] > 0 && arr2[i] > 0) {
                    list.add(i);
                    arr1[i] -= 1;
                    arr2[i] -= 1;
                }
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysIIv1(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]] += 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i: nums2) {
            if (arr1[i] > 0) {
                list.add(i);
                arr1[i] -= 1;
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysIIv2(int[] nums1, int[] nums2) {
        if (!(nums1.length >= nums2.length))
            return intersectionOfTwoArraysIIv2(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        int[] resultInt = new int[nums2.length];
        int ind = 0;
        for (int i: nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 0) {
                    resultInt[ind++] = i;
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        int[] result = new int[ind];
        for (int idx = 0; idx < result.length; idx++) {
            result[idx] = resultInt[idx];
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysIIBinSearch(int[] nums1, int[] nums2) {
        if (!(nums1.length >= nums2.length))
            return intersectionOfTwoArraysIIBinSearch(nums2, nums1);
        Arrays.sort(nums1);
        Map<Integer, Integer> m = arrayToMap(nums1);
        List<Integer> list = new ArrayList<>();
        for (int i: nums2) {
            int pos = BinarySearch.search(nums1, i);
            if (pos != -1) {
                if (m.get(i) > 0) {
                    list.add(i);
                    m.put(i, m.get(i) - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static List<Integer> convertToList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static int[] convertToArray(List<Integer> linteger) {
        return linteger.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersectionOfTwoArraysIIBruteForce(int[] nums1, int[] nums2) {
        if (!(nums1.length >= nums2.length))
            return intersectionOfTwoArraysIIBruteForce(nums2, nums1);
        HashMap<Integer, Integer> m1 = arrayToMap(nums1);
        HashMap<Integer, Integer> m2 = arrayToMap(nums2);
        List<Integer> list = new ArrayList<>();
        for (Integer key: m1.keySet()) {
            if (m2.containsKey(key)) {
                int v1 = m1.get(key);
                int v2 = m2.get(key);
                while (v1 > 0 && v2 > 0) {
                    list.add(key);
                    v1--;
                    v2--;
                }
            }
        }
        return convertToArray(list);
    }

    private static Set<Integer> arrayToSet(int[] arr) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            s.add(arr[i]);
        }
        return s;
    }


    private static HashMap<Integer, Integer> arrayToMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        return map;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = (nums1.length > nums2.length)? nums2.length: nums1.length;
        int[] result = new int[length];
        int idx = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                //increase count
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) != 0) {
                    //add to return arr
                    result[idx++] = nums2[i];
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        int[] returnArr = new int[idx];
        for (int i = 0; i < idx; i++) {
            returnArr[i] = result[i];
        }
        return returnArr;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int f = 0, s = 0;

        List<Integer> result = new ArrayList<Integer>();
        while (true) {

            if (f == nums1.length || s == nums2.length)
                break;

            if (nums1[f] > nums2[s])
                s++;
            else if (nums1[f] < nums2[s])
                f++;
            else {
                result.add(nums1[f]);
                f++;
                s++;
            }

        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    /*
     * Two Sum II - Input array is sorted
     * */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int second = target - numbers[i];
            int pos = BinarySearch.searchInRange(numbers, second, i + 1, numbers.length - 1);
            if (pos != -1)
                return new int[]{i + 1, pos + 1};
        }
        return new int[2];
    }

    public static int[] twoSumV2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int second = target - numbers[i];
            int l = i + 1, r = numbers.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (numbers[m] >= second) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (numbers[l] == second)
                return new int[]{i + 1, l + 1};
        }
        return new int[2];
    }

    public static int[] twoSumV3(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        boolean moveleft = true;
        while (true) {
            if (moveleft) {
                while (numbers[left] + numbers[right] < target) {
                    left++;
                }
                moveleft = false;
            } else {
                while (numbers[left] + numbers[right] > target) {
                    right--;
                }
                moveleft = true;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
        }
    }

    public static int[] twoSumV4(int[] numbers, int target) {
        int st = 0, en = numbers.length - 1;
        int index = -1;
        int index2 = -1;
        while (st < en) {
            int rst = numbers[st] + numbers[en];
            if (rst == target) {
                index = st + 1;
                index2 = en + 1;
                break;
            } else if (rst > target) {
                en--;
            } else {
                st++;
            }
        }
        int[] arr = new int[2];
        arr[0] = index;
        arr[1] = index2;
        return arr;
    }

    /*
    * Find the Duplicate Number
    * */
    public static int findDuplicate(int[] nums){
        int[] rawNums = new int[nums.length - 1];
        for(int i = 0; i < nums.length - 1; i++){
            rawNums[i] = i + 1;
        }
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i] - 1;
            if (rawNums[idx] > 0){
                rawNums[idx] = 0;
            } else {
                return nums[i];
            }

        }
        return 0;
    }

    /*
    * Median of Two Sorted Arrays
    * */
    public static double findMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianOfTwoSortedArrays(nums2, nums1);
        int total = nums1.length + nums2.length;
        int l = 0, r = nums1.length;
        while (true){
            int m1 = (l + r)/2;
            int m2 = (total + 1)/2 - m1;

            int left1 = m1 > 0? nums1[m1 - 1]: Integer.MIN_VALUE;
            int right1 = m1 < nums1.length? nums1[m1]: Integer.MAX_VALUE;

            int left2 = m2 > 0? nums2[m2 - 1]: Integer.MIN_VALUE;
            int right2 = m2 < nums2.length? nums2[m2]: Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1){
                if (total%2 == 0){
                    return Double.valueOf(Math.max(left1, left2) + Math.min(right1, right2))/2;
                } else {
                    return Double.valueOf(Math.max(left1, left2));
                }
            } else if (left1 > right2) {
                r = m1 - 1;
            } else {
                l = m1 + 1;
            }
        }
    }
}