package com.maria.pyramid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pyramid {

    /*
    * У нас есть пирамида, которая состоит из кирпичей, которые уложены друг на друга.
    * Каждый кирпич весит 1 кг, и при этом к каждому кирпичу на нижнем уровне добавляется часть веса предыдущих (см. картинку).
    * Нужно вычислить вес дельты для кирпича в определенной позиции.
    *
    * w(0, 0) = 0
    * w(1, 0) = w(1, 1) = 0.5
    * w(2, 0) = 0.75, w(2, 1) = 1.5, w(2, 2) = 0.75
    * */
    public static List<List<Double>> weights = new ArrayList<>();
    public static double getBrickWeight(int i, int j) {
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        weights.add(list);

        for (int row = 1; row <= i; row++) {
            List<Double> currList = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currList.add(1 + (weights.get(row - 1).get(0) / 2));
                } else {
                    currList.add(1 + weights.get(row - 1).get(col - 1) / 2 + weights.get(row - 1).get(col) / 2);
                }
            }
            weights.add(currList);
        }

        return weights.get(i).get(j) - 1.0;
    }

    public static double getBrickWeightOpt(int i, int j) {
        List<Double> prevList = new ArrayList<>();
        prevList.add(1.0);

        for (int row = 1; row <= i; row++) {
            List<Double> currList = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currList.add(1 + (prevList.get(0) / 2));
                } else {
                    currList.add(1 + (prevList.get(col - 1) / 2) + (prevList.get(col) / 2));
                }
            }
            prevList = currList;
        }
        return prevList.get(j) - 1.0;
    }

    public static Map<String, Double> mp = new HashMap<>();
    public static double getBrickWeightRecursive(int i, int j) {
        if (i == 0 && j == 0) {
            mp.put(i + "- " + j, 0.0);
            return 0.0;
        }
        if (mp.containsKey(i + "- " + j)){
            return mp.get(i + "- " + j);
        }

        double weight = 0.0;
        if (j == 0)
            weight += (1 + getBrickWeightRecursive(i - 1, 0)) / 2;
        else if (i == j)
            weight += (1 + getBrickWeightRecursive(i - 1, j - 1)) / 2;
        else
            weight += (1 + getBrickWeightRecursive(i - 1, j - 1)) / 2 + (1 + getBrickWeightRecursive(i - 1, j)) / 2;

        mp.put(i + "- " + j, weight);
        return mp.get(i + "- " + j);
    }
}
