package com.vvu.leetcode;

import com.vvu.list.ListNode;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class _0237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
