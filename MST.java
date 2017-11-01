package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MST {

	private static Scanner in;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Connection> input = new ArrayList<>();
		input.add(new Connection("A","B",1));
		input.add(new Connection("A","C",2));
		input.add(new Connection("B","C",3));
		List<Connection> output = lowestCost(input);
		for(Connection conn:output)
			System.out.println(conn.city1+" "+conn.city2+" "+conn.cost);
		
	}
	 public static class Connection {
		 public String city1, city2;
		 public int cost;
		 public Connection(String city1, String city2, int cost) {
		       this.city1 = city1;
		       this.city2 = city2;
		       this.cost = cost;
		    }
		 }
	 public static List<Connection> lowestCost(List<Connection> connections) {
	        List<Connection> res = new ArrayList<>();
	        if(connections ==null || connections.size()==0) return res;
	        PriorityQueue<Connection> result = new PriorityQueue<Connection>(11,new Comparator<Connection>(){
	            public int compare(Connection a,Connection b){
	                if(a.cost==b.cost){
	                    if(a.city1.compareTo(b.city1)==0){
	                        return a.city2.compareTo(b.city2);
	                    } else {
	                        return a.city1.compareTo(b.city1);
	                    }
	                } else {
	                    return a.cost-b.cost;
	                }
	            }
	        });
	        Map<String,String> map = new HashMap<>();
	        TreeSet<Connection> paths = new TreeSet<Connection>(new Comparator<Connection>(){
	            public int compare(Connection a,Connection b){
	                if(a.cost==b.cost){
	                    if(a.city1.compareTo(b.city1)==0){
	                        return a.city2.compareTo(b.city2);
	                    } else {
	                        return a.city1.compareTo(b.city1);
	                    }
	                } else {
	                    return a.cost-b.cost;
	                }
	            }
	        });
	        Set<String> unvisited = new HashSet<>();
	        for(Connection connection:connections){
	            map.put(connection.city1,connection.city1);
	            map.put(connection.city2,connection.city2);
	            paths.add(connection);
	            unvisited.add(connection.city1);
	            unvisited.add(connection.city2);
	        }
	        int count = unvisited.size();
	        while(!unvisited.isEmpty()){
	            if(paths.isEmpty()) return res;
	            Connection cur = paths.first();
	            if(!unvisited.contains(cur.city1) &&!unvisited.contains(cur.city2)) continue;
	            unvisited.remove(cur.city1);
	            unvisited.remove(cur.city2);
	            result.add(cur);
	            String s = findRoot(map,cur.city1);
	            String t = findRoot(map,cur.city2);
	            if(!t.equals(s)){
	                count--;
	                if(s.compareTo(t)<0)
	                    map.put(t,s);
	                else
	                    map.put(s,t);
	            }
	        }
	        if(count >1) return res;
	        while(!result.isEmpty())
	            res.add(result.poll());
	        return res;
	    }
	    private static String findRoot(Map<String,String> roots,String test){
	            while(!test.equals(roots.get(test))) {
	                roots.put(test,roots.get(roots.get(test)));
	                test = roots.get(test);
	            }
	            return test;
	    }
}

