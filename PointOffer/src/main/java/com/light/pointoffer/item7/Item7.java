package com.light.pointoffer.item7;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 */
public class Item7 {
	
	public static void main(String[] args) {
		
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		
		System.out.println(myQueue.pop());
		myQueue.push(5);
		myQueue.push(6);

		System.out.println(myQueue.pop());
		
		
	}

}
class MyQueue<E>{
	
	private Stack<E> stack1 = new Stack<E>();
	private Stack<E> stack2 = new Stack<E>();
	
	public boolean push(E e){
		stack1.push(e);
		return true;
	}
	
	public E pop(){
		if(stack2.isEmpty()){
			move();
		}
		return stack2.pop();
	}
	private void move(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
	
}