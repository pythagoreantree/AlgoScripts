package com.maria.recursion;

import org.junit.jupiter.api.Test;

import static com.maria.recursion.Recursion.*;
import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    @Test
    void reverseString() {
        char[] s = {'h','e','l','l','o'};
        Recursion.reverseString(s);
        System.out.println(s);
    }

    @Test
    void swapPairs() {
        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1};
//        int[] nums = {};
        Recursion.ListNode root = arrayToList(nums);
//        Recursion.ListNode root = buildList();
//        printList(root);
        root = Recursion.swapPairs(root);
        printList(root);
    }
}