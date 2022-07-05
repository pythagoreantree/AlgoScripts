package com.maria.trees.binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestTest {

    @Test
    void kthLargestInit() {
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        kthLargest.inOrderTraversal();
    }

    @Test
    void add(){
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
//        kthLargest.inOrderTraversal();
        int ans = kthLargest.add(3);
        Assertions.assertEquals(4, ans);
        ans = kthLargest.add(5);
        Assertions.assertEquals(5, ans);
        ans = kthLargest.add(10);
        Assertions.assertEquals(5, ans);
        ans = kthLargest.add(9);
        Assertions.assertEquals(8, ans);
        ans = kthLargest.add(4);
        Assertions.assertEquals(8, ans);
        ans = kthLargest.add(9);
        Assertions.assertEquals(9, ans);
    }

    @Test
    void addv2(){
        int[] nums = new int[]{5, 2, 6, 7, 1, 4};
        KthLargest kthLargest = new KthLargest(7, nums);
//        int ans = kthLargest.findKlargest(kthLargest.root, 5);
//        System.out.println(ans);
//        kthLargest.inOrderTraversal();
        int ans = kthLargest.add(3);
        System.out.println(ans);
    }
}