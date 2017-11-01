package test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i< 10; i++) {
			stack.push(i);
		}
		for (int i : stack)
			System.out.print(i);
		System.out.println();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i< 10; i++) {
			deque.push(i);
		}
		for (int i : deque)
			System.out.print(i);

	}

}
