package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class DataMean {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		File file = new File("Data-consolidation_InputForSubmission");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		double curMean = 0;
        while (in.hasNext()) {
        	String s = in.next();
        	String[] inputs = s.split(",");
        	for (String input : inputs) {
        		double curSum = curMean * count + Integer.parseInt(input);
        		count ++;
        		curMean = curSum / count;
        	}
        }
        PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
        writer.println((int) Math.round(curMean));
        writer.close();
	}

}
