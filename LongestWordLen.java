package test;

import java.util.Scanner;

public class LongestWordLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputs = {"What is the longest word",
				"Some words",
				"one",
				"Ek oh no",
				"a",
				"",
				"Just random tests",
				"Just a ere90wj0ew a 9dajf09aj a 9dfs09"};
		int[] ans = {7,5,3,2,1,0,6,10};
		boolean pass = true;
		int index = 0;
		for (String input : inputs) {
			if (longestWordLen(input) != ans[index++]) {
				System.out.println("Input \"" + input + "\" fails.");
				pass = false;
			}
		}
		System.out.println(pass ? "All tests passed" : "Tests failed.");
	}
	public static int longestWordLen(String words) {
		if (words == null || words.length() == 0)
			return 0;
		Scanner in = new Scanner(words);
		String word = in.next();
		if (!in.hasNext()) {
			in.close();
			return words.length();
		}
		int len = word.length();
		in.close();
		// String
		return Math.max(len, longestWordLen(words.substring(len+1)));
	}
}
