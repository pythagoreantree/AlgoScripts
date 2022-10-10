package com.maria.dp;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Parcels {

    public static int getMinimumDays(List<Integer> parcels) {
        Collections.sort(parcels);

        int startIndex = 0;
        while (startIndex < parcels.size() && parcels.get(startIndex) == 0) {
            startIndex++;
        }
        if (startIndex == parcels.size()) return 0;

        int count = 0;
        while (startIndex < parcels.size()) {

            Integer minNum = parcels.get(startIndex);

            for (int i = startIndex; i < parcels.size(); i++) {
                int currentNum = parcels.get(i) - minNum;
                if (currentNum == 0) {
                    startIndex++;
                }
                parcels.set(i, currentNum);
            }
            count++;
        }

        return count;
    }

    public static boolean allNulls(List<Integer> nums) {
        for (Integer n: nums) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }


    /*
    * Неверное решение
    * */
    public static int getMinimumDays2(List<Integer> parcels) {
        Set<Integer> set = new TreeSet(parcels);
        set.remove(0);
        return set.size();
    }
}
