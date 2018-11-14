package com.light.pointoffer.item5;

import java.util.Stack;

/**
 * 5.从尾到头打印链表
 *
 */
public class ReversePrintLinkedList {
	
	
	/**
	 * 利用栈 先进后出
	 * 时间复杂度O(2n)
	 * @param head
	 */
	public static void reversePrintWithStack(Node<Integer> head){
		
		Node<Integer> temp = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(temp!=null){
			stack.push(temp.getData());
			temp = temp.getNext();
		};
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}
	
	/**
	 * 递归实现方式
	 * @param head
	 */
	public static void reversePrintWithRecursion(Node<Integer> head){
		if(head==null) throw new RuntimeException();
		if(head.getNext()!=null){
			reversePrintWithRecursion(head.getNext());
		}
		System.out.println(head.getData());
	}
	
	
	
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		Node<Integer> node7 = new Node<Integer>(7);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		
		reversePrintWithStack(node1);
		
		reversePrintWithRecursion(node1);
		
		
	}
}
class Node<E>{
	private E data;
	private Node<E> next;
	
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node(E data){
		this.data = data;
	}
}
