package com.maria.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

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
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0}};
    }

    public static boolean knows(int a, int b) {
        return friendsMap[a][b] == 1? true: false;
    }

    //Stack Implementation
    public static int findCelebrityWithStack(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = (n - 1); i >= 0; i--) {
            stack.push(i);
        }
        while (stack.size() > 1) {
           Integer one = stack.pop();
           Integer two = stack.pop();
           if (knows(one, two)) {
               stack.push(two);
           } else {
               stack.push(one);
           }
        }

        Integer celebrity = stack.pop();
        int knowsCelebrityNum = 0;
        int isKnownByCelebrityNum = 0;

        for (int i = 0; i < n; i++) {
            if (i != celebrity) {
                if (knows(i, celebrity)) {
                    knowsCelebrityNum++;
                }
                if (knows(celebrity, i)) {
                    isKnownByCelebrityNum++;
                }
            }
        }
        if (isKnownByCelebrityNum != 0 || knowsCelebrityNum != (n - 1)) {
            return -1;
        }
        return celebrity;
    }

    //In-Out Degree Method
    public static int findCelebrityWithGraph(int n) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    outDegree[i] += 1;
                    inDegree[j] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == (n - 1) && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int findCelebrityTwoPointers(int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            if (knows(i, j)) {
                i++;
            } else {
                j--;
            }
        }
        for (int k = 0; k < n; k++) {
            if (k != i && (knows(i, k) || !knows(k, i))) {
                return -1;
            }
        }
        return i;
    }
}
