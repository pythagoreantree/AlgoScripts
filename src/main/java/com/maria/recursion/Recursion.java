package com.maria.recursion;

import com.maria.trees.TreeNode;

import java.lang.reflect.Array;
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


    public static ListNode buildList(int[] arr) {
        return arrayToList(arr);
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
        if (n < 2)
            return n;
        dp4.add(0);
        dp4.add(1);

        int i = 2;
        while (i <= n) {
            dp4.add(dp4.get(i - 1) + dp4.get(i - 2));
            i++;
        }

        return dp4.get(dp4.size() - 1);
    }

    public static int fib3(int n) {
        if (n < 2)
            return n;

        int i = 2, num = 1, result = 1;
        while (i < n) {
            int n2 = result;
            result += num;
            num = n2;
            i++;
        }
        return result;
    }

    public static int climbStairs(int n) {
        return climb(0, n);
    }

    public static Map<Integer, Integer> dpCLimb = new HashMap<>();
    public static int climb(int level, int target) {
        if (level == target)
            return 1;
        if (level > target)
            return 0;
        if (dpCLimb.containsKey(level)){
            return dpCLimb.get(level);
        }
        int levelCount = climb(level + 1, target) + climb(level + 2, target);
        dpCLimb.put(level, levelCount);
        return levelCount;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;

        if (list1.val > list2.val) {
            return mergeTwoLists(list2, list1);
        }
        ListNode head = list1, pt1 = list1, parent = list1, pt2 = list2;

        while (pt2 != null) {
            while (pt1 != null && pt1.val <= pt2.val){
                parent = pt1;
                pt1 = pt1.next;
            }
            ListNode tmp = pt2;
            pt2 = pt2.next;
            tmp.next = pt1;
            parent.next = tmp;
            parent = tmp;
        }
        return head;
    }

    public static List<Integer> current = new ArrayList<>();
    public static List<Integer> temporary = new ArrayList<>();
    static {
        current.add(0);
    }
    public static int kthGrammar(int n, int k) {
        int j = 2;
        while (j <= n) {
            for (Integer symbol : current) {
                switch (symbol) {
                    case 0:
                        temporary.add(0);
                        temporary.add(1);
                        break;
                    case 1:
                        temporary.add(1);
                        temporary.add(0);
                        break;
                    default:
                        throw new RuntimeException("Unknown symbol: " + symbol);
                }
            }
            current.clear();
            current.addAll(temporary);
            temporary.clear();
            j++;
        }
        System.out.println(current);
        return current.get(k-1);
    }

    public static List<Integer> state = new ArrayList<>();
    public static int kthGrammarII(int n, int k) {
        if (k == 1) {
            int curr = 0;
            for (int i = state.size()-1; i >= 0; i--){
                if (state.get(i) == 1){
                    if (curr == 0)
                        curr = 1;
                    else
                        curr = 0;
                } else {
                    if (curr == 0)
                        curr = 0;
                    else
                        curr = 1;
                }
            }
            return curr;
        }

        if (k % 2 == 0) {
            state.add(1);
            return kthGrammarII(n-1, k/2);
        } else {
            state.add(0);
            return kthGrammarII(n-1, (k+1)/2);
        }
    }

    public static List<List<Integer>> uniqueBST(int n) {
//        List<List<Integer>> result = f1(1, n);
        return f1(1, n);
    }

    private static List<List<Integer>> f1(int start, int end) {
        if (start == end) {
            List<Integer> internal = new ArrayList<>();
            List<List<Integer>> external = new ArrayList<>();
            internal.add(start);
            external.add(internal);
            return external;
        }

        List<List<Integer>> currList = new ArrayList<>();
        for (int j = start; j <= end; j++) {
            int curr = j;
//            if (start == 0 && end == 3 && curr == 2)
//                System.out.println("Debug Point!");

            List<List<Integer>> left = null;
            if (j != start) {
                left = f1(start, j - 1);
            }

            List<List<Integer>> right = null;
            if (j != end) {
                right = f1(j + 1, end);
            }

            if (left == null && right != null && !right.isEmpty()) {
                for (List list: right) {
                    list.add(0, curr);
                    list.add(1, null);
                    currList.add(list);
                }
            } else if (right == null && left != null && !left.isEmpty()) {
                for (List list: left) {
                    list.add(0, curr);
                    list.add(2, null);
                    currList.add(list);
                }
            } else if (left != null && right != null) {
                for (int i1 = 0; i1 < left.size(); i1++) {
                    for (int j1 = 0; j1 < right.size(); j1++) {
                        List res = new ArrayList();
                        res.add(curr);
                        res.addAll(left.get(i1));
                        res.addAll(right.get(j1));
                        currList.add(res);
                    }
                }
            }
        }
        return currList;
    }

    public static List<TreeNode> generateTrees(int n) {
        return getTrees(1, n);
    }

    private static List<TreeNode> getTrees(int start, int end) {
        if (start == end) {
            List<TreeNode> l = new ArrayList<>();
            l.add(new TreeNode(start));
            return l;
        }

        List<TreeNode> levelList = new ArrayList<>();
        for (int j = start; j <= end; j++) {

            List<TreeNode> left = null;
            if (j != start) {
                left = getTrees(start, j - 1);
            }

            List<TreeNode> right = null;
            if (j != end) {
                right = getTrees(j + 1, end);
            }

            if (left == null && right != null && !right.isEmpty()) {
                for (int i = 0; i < right.size(); i++) {
                    TreeNode currNode = new TreeNode(j);
                    currNode.right = right.get(i);
                    levelList.add(currNode);
                }
            } else if (right == null && left != null && !left.isEmpty()) {
                for (int i = 0; i < left.size(); i++) {
                    TreeNode currNode = new TreeNode(j);
                    currNode.left = left.get(i);
                    levelList.add(currNode);
                }
            } else if (left != null && right != null) {
                for (int i1 = 0; i1 < left.size(); i1++) {
                    for (int j1 = 0; j1 < right.size(); j1++) {
                        TreeNode currNode = new TreeNode(j);
                        currNode.left = left.get(i1);
                        currNode.right = right.get(j1);
                        levelList.add(currNode);
                    }
                }
            }
        }
        return levelList;
    }
}
