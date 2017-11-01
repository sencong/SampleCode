package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class MyProg {
	 public static void main(String[] args) {
		 try {
		 ArrayList<String> lines = readFile();
		 int maxSoFar = 0;
		 for (int i = 0; i < lines.size(); i++) {
			 if (lines.get(i).length() > maxSoFar) {
			 maxSoFar = lines.get(i).length();
			 }
		 }
		 System.out.println("Max line is " + maxSoFar);
		 }

		 catch (IOException exc) {
		 System.out.println("Error #2");
		 }
	 }
	 public static ArrayList<String> readFile() throws IOException {
	 ArrayList<String> lines = new ArrayList<String>();
	 try {
	 Scanner inFile = new Scanner(new File("inputData"));
	 
	 }
	 catch (FileNotFoundException exc) {
	 System.out.println("Error #3");
	 }
	 return lines;
	 }
	}
