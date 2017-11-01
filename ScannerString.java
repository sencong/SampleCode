package test;

import java.util.Scanner;

public class ScannerString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "What";
		System.out.println(longestWordLen(s));
	}
	private static int longestWordLen(String words) {
		if (words == null) 
			return 0;
	
		Scanner in = new Scanner(words);
		if (!in.hasNext()){
			in.close();
			return words.length();
		}
			
		String word = in.next();
		int len = word.length();
		in.close();
		// String
		return Math.max(len, longestWordLen(words.substring(len+1)));
	}

}
