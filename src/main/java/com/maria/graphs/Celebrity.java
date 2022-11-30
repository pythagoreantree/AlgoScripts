package com.maria.graphs;

public class Celebrity {

    public static final Integer MINUS_INF = -1000;
    public static int findCelebrity(int n) {
        int[] whoKnows = new int[n];
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(i, n, seen, whoKnows);
            }
        }
        for (int k = 0; k < n; k++) {
            if (whoKnows[k] == (n - 1))
                return k;
        }
        return -1;
    }

    private static void dfs(int i, int n, boolean[] seen, int[] whoKnows) {
        seen[i] = true;
        for (int j = 0; j < n; j++) {
            if (knows(i, j)) {
                whoKnows[i] = MINUS_INF;
                if (whoKnows[j] != MINUS_INF) whoKnows[j] += 1;
                if (!seen[j])
                    dfs(j, n, seen, whoKnows);
            }
        }

    }

    public static Integer[][] friendsMap;

    static {
        friendsMap = new Integer[][]{
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0}};
    }
    public static boolean knows(int a, int b) {
        return friendsMap[a][b] == 1? true: false;
    }
}
