package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StringTester1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "juliasamanthasamanthajulia",x ="ant*as";
		System.out.println(firstOccurrence(s,x));
		
	}
	static int firstOccurrence(String s,String x) {
		if (s == null || x == null)
            return -1;
        if (!x.contains("*"))
            return s.indexOf(x);
        int res = s.length();
        for (char ch = 'a'; ch <='z'; ch++) {
        	String rest = x.replace('*',ch);
            res = Math.min(res,s.indexOf(rest));
        }
        return res == s.length() ? -1 : res; 
	}
}
