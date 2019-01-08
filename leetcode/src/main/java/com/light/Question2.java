package com.light;

import java.util.List;

/**
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class Question2 {
    public static void main(String[] args) {

        Question2 test = new Question2();

        ListNode l1 = new ListNode(2);
        ListNode l1node_4 = new ListNode(4);
        ListNode l1node_3 = new ListNode(3);
        l1.next=l1node_4;
        l1node_4.next=l1node_3;

        ListNode l2 = new ListNode(5);
        ListNode l2node_6 = new ListNode(6);
        ListNode l2node_4 = new ListNode(4);
        l2.next=l2node_6;
        l2node_6.next=l2node_4;

        System.out.println(test.print(l1));
        System.out.println(test.print(l2));

        ListNode result = test.addTwoNumbers(l1,l2);
        System.out.println(test.print(result));
    }
    public String print(ListNode l1){
        StringBuilder sb = new StringBuilder();
        while (l1!=null){
            sb.append(l1.val+",");
            l1=l1.next;
        }
        return (sb.toString());

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;

        ListNode temp = null;

        boolean haxUp = false;

        while (l1!=null||l2!=null||haxUp){
            int val = (l1==null?0:l1.val)+(l2==null?0:l2.val)+(haxUp?1:0);
            if (val>=10){
                val=val-10;
                haxUp=true;
            }else{
                haxUp=false;
            }
            ListNode newNode = new ListNode(val);
            if(head==null) {
                head = newNode;
                temp = newNode;
            }
            else {
                temp.next=newNode;
                temp = newNode;
            }
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }

        return head;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}