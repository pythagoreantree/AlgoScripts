package com.maria.strings;

public class FinalValueofVariable {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op: operations) {
            switch(op) {
                case "++X":
                    ++x;
                    break;
                case "X++":
                    x++;
                    break;
                case "--X":
                    --x;
                    break;
                case "X--":
                    x--;
                    break;
            }

        }
        return x;
    }

    public int finalValueAfterOperationsV2(String[] operations) {
        int x = 0;
        for (String op: operations) {
            if (op.charAt(1) == '+')
                x++;
            if (op.charAt(1) == '-')
                x--;

        }
        return x;
    }
}
