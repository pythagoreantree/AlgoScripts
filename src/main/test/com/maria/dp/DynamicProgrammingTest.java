package com.maria.dp;

import org.junit.jupiter.api.Test;

class DynamicProgrammingTest {

    @Test
    void gridTraveler() {
        long ans1 = DynamicProgramming.gridTraveler(2, 3);
        System.out.println(ans1);

        DynamicProgramming.dp.clear();

        long ans2 = DynamicProgramming.gridTraveler(3, 3);
        System.out.println(ans2);

        DynamicProgramming.dp.clear();

        long ans3 = DynamicProgramming.gridTraveler(1, 1);
        System.out.println(ans3);

        DynamicProgramming.dp.clear();

        long ans4 = DynamicProgramming.gridTraveler(18, 18);
        System.out.println(ans4);

        DynamicProgramming.dp.clear();
    }

    @Test
    void gridTravelerTabulation() {
        long ans = DynamicProgramming.gridTravelerTabulation(18, 18);
        System.out.println(ans);
    }

    @Test
    void fibTabulation() {
        long ans = DynamicProgramming.fibTabulation(6);
        System.out.println(ans);

        ans = DynamicProgramming.fibTabulation(8);
        System.out.println(ans);

        ans = DynamicProgramming.fibTabulation(50);
        System.out.println(ans);
    }
}