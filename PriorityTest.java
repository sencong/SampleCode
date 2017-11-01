package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PriorityTest {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int enter = 0;
        PriorityQueue<PriorityEntry> pq = new PriorityQueue<>();
        while(in.hasNextLine()) {
            String curLine = in.nextLine();
            String[] contents = curLine.split("\\s+");
            if (contents[0].equals("DEQUEUE")) {
                System.out.println(pq.poll().getName());
            } else if (contents[0].equals("ENQUEUE")) {
                pq.offer(new PriorityEntry(contents[1], Integer.parseInt(contents[2]),enter++));
            }
        }
        
    }
    
}
class PriorityEntry implements Comparable{
    private String identifier;
    private int priority;
    private int enter;
    public PriorityEntry (String identifier, int priority, int enter) {
        this.identifier = identifier;
        this.priority = priority;
        this.enter = enter;
    }
    public String getName(){
        return identifier;
    }
    int compareTo (PriorityEntry other) {
        if (priority == other.priority) {
            return enter - other.enter;
        } else {
            return other.priority - priority;
        }
    }
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}