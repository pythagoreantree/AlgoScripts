package com.maria.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recursion {

    public static void reverseString(char[] s) {
        processCharAtIndex(0, s.length - 1, s);
    }

    public static void processCharAtIndex(int left, int right, char[] s) {
        if (right <= left) {
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
        printCharAtIndex(index + 1, s);
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

    public static ListNode swapNodes(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
        next.next = node;
        return next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode buildList() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        return root;
    }

    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head;
    }

    public static void printList(ListNode node) {
        if (node == null)
            return;
        if (node.next == null) {
            System.out.print(node.val);
            return;
        }
        System.out.print(node.val);
        System.out.print(" ");
        printList(node.next);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        return reverse(head, null);
    }

    public static ListNode reverse(ListNode node, ListNode prev) {
        if (node != null && node.next == null) {
            node.next = prev;
            return node;
        }
        ListNode head = reverse(node.next, node);
        node.next = prev;
        return head;
    }

    public static ListNode reverseListInCycle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nn;
        }
        return prev;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(getPascalNumber(rowIndex, i));
        }
        return row;
    }

    public static Map<Integer[], Integer> dp = new HashMap<>();

    public static int getPascalNumber(int rowIndex, int colIndex) {
        if (rowIndex == 0)
            return 1;
        if (colIndex == 0 || colIndex == rowIndex) {
            return 1;
        }
        Integer[] arrToCheck = {rowIndex, colIndex};
        if (dp.containsKey(arrToCheck))
            return dp.get(arrToCheck);
        int num = getPascalNumber(rowIndex - 1, colIndex - 1) + getPascalNumber(rowIndex - 1, colIndex);
        Integer[] arr = {rowIndex, colIndex};
        dp.put(arr, num);
        return num;
    }

    public static Map<Integer, List<Integer>> dp2 = new HashMap<>();

    public static List<Integer> getRowII(int rowIndex) {
        List<Integer> linit = new ArrayList<>();
        linit.add(1);

        if (rowIndex == 0) {
            return linit;
        }

        dp2.put(0, linit);

        int currRow = 1;
        while (currRow <= rowIndex) {
            for (int colIndex = 0; colIndex <= currRow; colIndex++) {
                if (colIndex == 0 || colIndex == currRow) {
                    if (!dp2.containsKey(currRow)) {
                        dp2.put(currRow, new ArrayList<>());
                    }
                    List<Integer> l = dp2.get(currRow);
                    l.add(1);
                    dp2.put(currRow, l);
                } else {
                    List<Integer> l = dp2.get(currRow - 1);
                    int val = l.get(colIndex - 1) + l.get(colIndex);
                    List<Integer> l0 = dp2.get(currRow);
                    l0.add(val);
                    dp2.put(currRow, l0);
                }
            }
            currRow++;
        }
        return dp2.get(rowIndex);
    }

    public static List<Integer> getRowIII(int rowIndex) {
        ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        p.add(al);

        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> prevList = p.get(i - 1);
            al = new ArrayList<Integer>();
            al.add(1);
            for (int j = 0; j < i - 1; j++) {
                al.add(prevList.get(j) + prevList.get(j + 1));
            }
            al.add(1);
            p.add(al);
        }
        return p.get(rowIndex);
    }

    public static Map<Integer, Integer> dp3 = new HashMap<>();

    public static int fib1(int n) {
        if (n < 2)
            return n;
        if (dp3.containsKey(n))
            return dp3.get(n);
        int val = fib1(n - 1) + fib1(n - 2);
        dp3.put(n, val);
        return val;
    }

    public static List<Integer> dp4 = new ArrayList<>();
    public static int fib2(int n) {
        if (n < 2) return n;
        dp4.add(0);
        dp4.add(1);

        int i = 2;
        while (i <= n) {
            dp4.add(dp4.get(i-1) + dp4.get(i-2));
            i++;
        }

        return dp4.get(dp4.size()-1);
    }

    public static int fib3(int n) {
        if (n < 2) return n;

        int i = 2, num = 1, result = 1;
        while (i < n) {
            int n2 = result;
            result += num;
            num = n2;
            i++;
        }
        return result;
    }
}
