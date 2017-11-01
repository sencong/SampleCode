package test;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.*;

public class SetGame {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		File file = new File("PracticeInput3.txt");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int t = in.nextInt();
		in.nextLine();
		PrintWriter writer = new PrintWriter("Output3.txt", "UTF-8");
		for(int a0 = 0; a0 <t; a0++) {
			writer.print("Group " + (a0+1) + ": ");
			
			String[] cur = in.nextLine().split(" ");
			Set<Integer> countSet = new HashSet<>(Arrays.asList(1,2,3));
			Set<Character> fillSet = new HashSet<>(Arrays.asList('E','F','S'));
			Set<Character> colorSet = new HashSet<>(Arrays.asList('G','P','R'));
			Set<Character> shapeSet = new HashSet<>(Arrays.asList('O','D','S'));
			countSet.remove(cur[0].charAt(0) - '0');
			if (countSet.contains(cur[1].charAt(0) - '0')) {
				countSet.remove(cur[1].charAt(0) - '0');
				writer.print(countSet.iterator().next());
			} else {
				writer.print(cur[0].charAt(0));
			}
			
			fillSet.remove(cur[0].charAt(1));
			if (fillSet.contains(cur[1].charAt(1))) {
				fillSet.remove(cur[1].charAt(1));
				writer.print(fillSet.iterator().next());
			} else {
				writer.print(cur[0].charAt(1));
			}
			
			colorSet.remove(cur[0].charAt(2));
			if (colorSet.contains(cur[1].charAt(2))) {
				colorSet.remove(cur[1].charAt(2));
				writer.print(colorSet.iterator().next());
			} else {
				writer.print(cur[0].charAt(2));
			}
			
			
			shapeSet.remove(cur[0].charAt(3));
			if (shapeSet.contains(cur[1].charAt(3))) {
				shapeSet.remove(cur[1].charAt(3));
				writer.print(shapeSet.iterator().next());
			} else {
				writer.print(cur[0].charAt(3));
			}
			writer.println();
			
		}
		
        
        
        writer.close();
	}
	
}

