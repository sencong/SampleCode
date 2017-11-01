package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Bseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputs = {"5","2","C","D","+"};
		System.out.println(calPoints(inputs));
	}
	public static int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D" :
                    stack.push(stack.peek() * 2);
                    break;
                case "+" :
                    int last = stack.pop();
                    int newData = stack.peek() * last;
                    stack.push(last);
                    stack.push(newData);
                    break;
                default :
                    stack.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        for (int num : stack)
            res += num;
        return res;
    }

}
