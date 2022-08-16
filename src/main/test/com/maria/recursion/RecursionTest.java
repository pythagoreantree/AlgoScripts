package com.maria.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void reverseList() {
        int[] nums = {1, 2, 3};
        Recursion.ListNode root = arrayToList(nums);
        ListNode head = Recursion.reverseListInCycle(root);
        printList(head);
    }

    @Test
    void getRow() {
        List<Integer> l = Recursion.getRow(21);
        System.out.println(l);
    }

    @Test
    void getPascalNumber() {
        int num = Recursion.getPascalNumber(5, 2);
        System.out.println(num);
    }

    @Test
    void getRowII() {
        List<Integer> listBottomUp = Recursion.getRowII(21);
        System.out.println(listBottomUp);
    }

    @Test
    void getRowIII() {
        List<Integer> listBottomUp = Recursion.getRowIII(21);
        System.out.println(listBottomUp);
    }


    @Test
    void fib1() {
        for (int i = 0; i <= 20; i++){
            System.out.print(Recursion.fib1(i) + " ");
        }
    }

    @Test
    void fib2() {
        for (int i = 0; i <= 20; i++){
            System.out.print(Recursion.fib2(i) + " ");
            Recursion.dp4.clear();
        }
    }

    @Test
    void fib3() {
        for (int i = 0; i <= 20; i++){
            System.out.print(Recursion.fib3(i) + " ");
        }
    }

    @Test
    void climbStairs() {
        System.out.println(Recursion.climbStairs(4));
    }
}