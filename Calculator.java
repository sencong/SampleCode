package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate("1+2*3*4*5+6"));
	}
	static int calculate(String s){
		int num = 0;
		Deque<Integer> numStack = new ArrayDeque<>();
		Deque<Character> opStack = new ArrayDeque<>();
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i)==' ') continue;
			if(Character.isDigit(s.charAt(i))){
				num = num * 10 + s.charAt(i)-'0';
			} 
			if(i == s.length()-1 || !Character.isDigit(s.charAt(i+1))){
				numStack.push(num);
				num = 0;
			}
			if(!Character.isDigit(s.charAt(i))) {
				if(s.charAt(i) == '+'){
					while(!opStack.isEmpty() && (opStack.peek() == '*' || opStack.peek() == '^')){
						evaluate(numStack,opStack);
					}
				}
				if(s.charAt(i) == '*'){
					while(!opStack.isEmpty() && opStack.peek() == '^'){
						evaluate(numStack,opStack);
					}
				}
				opStack.push(s.charAt(i));
			}
		}
		while(!opStack.isEmpty()){
			evaluate(numStack,opStack);
		}
		return numStack.peek();
	}
	static void evaluate(Deque<Integer> numStack, Deque<Character> opStack){
		int num1 = numStack.pop();
		int num2 = numStack.pop();
		char op = opStack.pop();
		switch (op){
			case '+': 
				numStack.push(num1+num2);
				break;
			case '*':
				numStack.push(num2*num1);
				break;
			case '^':
				numStack.push((int) Math.pow(num2, num1));
				break;						
		}
	}

}
