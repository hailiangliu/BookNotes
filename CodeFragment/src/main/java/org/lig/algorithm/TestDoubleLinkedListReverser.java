package org.lig.algorithm;

public class TestDoubleLinkedListReverser {

    public static void main(String[] args) {

        TestDoubleLinkedListReverser tester = new TestDoubleLinkedListReverser();

        MyNode head = tester.prepareData(new int[]{1,2,3,4,5,8});


        tester.printMyNodeList(head);

        MyNode result = DoubleLinkedListReverser.reverse(head);

        tester.printMyNodeList(result);

    }
    private MyNode prepareData(int[] source){

        if(source==null)return null;

        MyNode node = null;
        MyNode prev = null;
        MyNode head = null;
        for(int i=0;i<source.length;i++){
            node=new MyNode(source[i]);
            if(i==0){
                head = node;
            }
            node.setPrev(prev);
            if(prev!=null)prev.setNext(node);
            prev = node;

        }
        return head;
    }
    private void printMyNodeList(MyNode head){
        StringBuilder sb = new StringBuilder();
        while(head!=null){
            sb.append(head.getData());
            head=head.getNext();
            if(head!=null) sb.append(",");
        }
        System.out.println(sb.toString());
    }
}
