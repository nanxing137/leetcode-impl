package com.acouchis.easy;

/**
 * Created by gaopeng09 on 2019-12-26
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            ListNode min = getMin(l1, l2);
            if (temp != null) {
                temp.next = min;
                temp = temp.next;
            } else {
                temp = min;
                result = temp;
            }
            if (min == null) {
                break;
            }
            if (!b) {
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
        }
        return result;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        System.out.println(new MergeTwoLists().mergeTwoLists(l1, l2));

    }

    private ListNode getMin(ListNode l1, ListNode l2) {
        if (l1 == null) {
            if (l2 == null) {
                return null;
            }
            b = false;
            return l2;
        } else if (l2 == null) {
            b = true;
            return l1;
        } else if (l1.val > l2.val) {
            b = false;
            return l2;
        } else {
            b = true;
            return l1;
        }

    }

    private volatile boolean b = true;


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
