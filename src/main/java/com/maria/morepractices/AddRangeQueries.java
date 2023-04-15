package com.maria.morepractices;

public class AddRangeQueries {

    public int[][] rangeAddQueriesV1(int n, int[][] queries) {
        int[][] m = new int[n][n];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            for (int j = q[0]; j <= q[2]; j++) {
                for (int k = q[1]; k <= q[3]; k++) {
                    m[j][k]++;
                }
            }
        }
        return m;
    }

    public String capitalizeTitle(String title) {
//        String[] arr = title.split(" ");
//        for (int i = 0; i < arr.length; i++) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(arr[i].);
//        }
        return "";
    }
}
