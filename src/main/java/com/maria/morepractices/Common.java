package com.maria.morepractices;

import com.maria.binarysearch.BinarySearch;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Common {

    /*
    * Intersection of Two Arrays
    * */
    public static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];
        for (int i = 0; i < nums1.length; i++){
            arr1[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++){
            arr2[nums2[i]] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            if (arr1[i] == 1 && arr2[i] == 1)
                list.add(i);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArrays2(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int i: nums1){
            s.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i: nums2){
            if(s.contains(i)){
                s.remove(i);
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        int idx = 0;
        for (Integer i: list){
            result[idx++] = i;
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysBinSearch(int[] nums1, int[] nums2) {
        if (!(nums1.length > nums2.length)){
            int[] numsSwap = nums1;
            nums1 = nums2;
            nums2 = numsSwap;
        }
        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();
        for(int i: nums2) {
            int pos = BinarySearch.search(nums1,i);
            if(pos != -1 && !list.contains(i))
                list.add(i);
        }
        int[] result = new int[list.size()];
        for(int i =0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysBruteForce(int[] nums1, int[] nums2) {
        if (!(nums1.length > nums2.length)){
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
        for (int i = 0; i < result.length; i++){
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
        for (int i = 0; i < nums1.length; i++){
            arr1[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++){
            arr2[nums2[i]] += 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++){
            if (arr1[i] > 0 && arr2[i] > 0){
                while (arr1[i] > 0 && arr2[i] > 0){
                    list.add(i);
                    arr1[i] -= 1;
                    arr2[i] -= 1;
                }
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysIIv2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums1){
            if (!map.containsKey(i)){
                map.put(i, 0);
            }
            int val = map.get(i);
            map.put(i, ++val);
        }

        List<Integer> list = new ArrayList<>();
        for (int i: nums2){
            if(map.containsKey(i)){
                int val = map.get(i);
                if (val > 0){
                    list.add(i);
                    map.put(i, --val);
                }
            }
        }

        int[] result = new int[list.size()];
        int idx = 0;
        for (Integer i: list){
            result[idx++] = i;
        }
        return result;
    }

    public static int[] intersectionOfTwoArraysIIBinSearch(int[] nums1, int[] nums2) {
        if (!(nums1.length > nums2.length)){
            int[] numsSwap = nums1;
            nums1 = nums2;
            nums2 = numsSwap;
        }
        Arrays.sort(nums1);
        List<Integer> intList = convertToList(nums1);
        List<Integer> list = new ArrayList<>();
        for(int i: nums2) {
            int pos = BinarySearch.search(nums1,i);
            if(pos != -1){
                list.add(i);
                intList.remove(pos);
                nums1 = convertToArray(intList);
            }
        }
        int[] result = new int[list.size()];
        for(int i =0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    private static List<Integer> convertToList(int[] arr){
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static int[] convertToArray(List<Integer> linteger){
        return linteger.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersectionOfTwoArraysIIBruteForce(int[] nums1, int[] nums2) {
        if (!(nums1.length > nums2.length)){
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
        for (int i = 0; i < result.length; i++){
            resultSimple[i] = result[i].intValue();
        }
        return resultSimple;
    }

    private static Set<Integer> arrayToSet(int[] arr){
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++){
            s.add(arr[i]);
        }
        return s;
    }


    private static HashMap<Integer, Integer> arrayToMap(int[] arr){
        return null;
    }
}
