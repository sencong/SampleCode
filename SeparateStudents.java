package test;

import java.util.Scanner;

public class SeparateStudents {

	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int numTest = in.nextInt();
		for(int a0 = 0;a0 < numTest;a0++){
			String s = in.next();
			s = s.replaceAll(" ", "");
			int ones = 0;
			for(char c:s.toCharArray()){
				if(c == '1') ones ++;
			}
			System.out.println(sepStu(s,ones));
		}
	}
	static int sepStu(String s, int ones){
		if(ones >= s.length() || ones < 1)
			return -1;
		char[] arr = s.toCharArray();
		int count = 0; 
		for(int i =0;i<ones;i++){
			if(arr[i] != '1'){
				int j = i+1;
				while(arr[j] != '1'){
					j++;
					if(j == s.length())
						return -1;
				}
				swap(arr, i,j);
				count += j-i;
			}		
		}
		arr = s.toCharArray();
		int countReverse = 0; 
		for(int i =0;i<s.length()-ones;i++){
			if(arr[i] != '0'){
				int j = i+1;
				while(arr[j] != '0'){
					j++;
					if(j == s.length());
						return -1;
				}
				swap(arr, i,j);
				countReverse += j-i;
			}		
		}
		return Math.min(count, countReverse);
	}
	static void swap(char[] arr,int i,int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
