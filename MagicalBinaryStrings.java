package test;

import java.util.*;

public class MagicalBinaryStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		int numTest = in.nextInt();
//		for(int a0 = 0;a0 < numTest;a0++){
//			String s = in.next();
//			System.out.println(magic(s));
//		}
		String s = "1110110001110111000010110000";
		System.out.println(magic(s));
	}
	static String magic(String s){
		if(s.length() == 0) return s;
		int ones = 0, zeros = 0 , curOnes = 0;
		/*
		 * ones relates to how many ones we should print in front of the pairs extracted from the arraylist
		 * zeros means the current number of zeros, which may continue to expand so that the magic segment length increases
		 * curOnes decides when zeros are too large,the number should go into the arraylist decided by the pairing curOnes
		 */
		StringBuilder sb = new StringBuilder();
		List<Integer> consecutive = new ArrayList<>();
		for(int cur = 0;cur<s.length();cur++){
			if(s.charAt(cur) == '1'){
				ones ++;
				if (cur > 0 && s.charAt(cur-1) == '0'){
					if(curOnes >= zeros){
						consecutive.add(zeros);
						zeros = 0;
					}
					curOnes = 1;
				}
				else
					curOnes ++;
				
			} else{
					if(curOnes > zeros){
						zeros ++;
						ones --;
					} else {
						consecutive.add(curOnes);
						addToSb(sb,consecutive,ones);
						curOnes = 0;
						zeros = 0;
						sb.append('0');
						ones = 0;
					}
			}
			
		}
		consecutive.add(zeros);
		addToSb(sb,consecutive,ones);
		
		return sb.toString();
	}
	/*
	 * addToSb adds the front 1s and the sorted reverse order of the magic segment lengths
	 */
	static void addToSb(StringBuilder sb, List<Integer> consecutive, int dangles){
		Collections.sort(consecutive,Collections.reverseOrder());
		for(int i = 0;i< dangles;i++){
			sb.append('1');
		}
		for(int i:consecutive){
			for(int j = 0;j<i;j++)
				sb.append('1');
			for(int j = 0;j<i;j++)
				sb.append('0');
		}
		consecutive.clear();
//		for(int i = 0;i< dangles;i++){
//			sb.append('0');
//		}
	}

}
