package com.maria.recursion;

public class Recursion {

    public static void reverseString(char[] s) {
        processCharAtIndex(0, s.length - 1, s);
    }

    public static void processCharAtIndex(int left, int right, char[] s) {
        if (right <= left){
            return;
        }
        char c = s[left];
        s[left] = s[right];
        s[right] = c;
        processCharAtIndex(++left, --right, s);
    }

    /*private static void swap(int pos1, int pos2, char[] s) {

    }*/

    public static void printCharAtIndex(int index, char[] s) {
        if (index == s.length - 1) {
            System.out.print(s[index] + " ");
            return;
        }
        printCharAtIndex(index+1, s);
        System.out.print(s[index] + " ");
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        head = head.next;
        first.next = head.next;
        head.next = first;
        head.next.next = swapPairs(head.next.next);
        return head;
    }

    public static ListNode swapNodes(ListNode node){
        ListNode next = node.next;
        node.next = next.next;
        next.next = node;
        return next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode buildList() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        return root;
    }

    public static ListNode arrayToList(int[] arr){
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++){
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head;
    }

    public static void printList(ListNode node){
        if (node == null) return;
        if (node.next == null){
            System.out.print(node.val);
            return;
        }
        System.out.print(node.val);
        System.out.print(" ");
        printList(node.next);
    }
}
