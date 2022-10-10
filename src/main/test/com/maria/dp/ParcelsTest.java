package com.maria.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParcelsTest {

    @Test
    void getMinimumDays() {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 2, 1, 0));
        int ans = Parcels.getMinimumDays2(nums);
        System.out.println(ans);
    }
}