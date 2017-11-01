package test;

import java.io.*;
import java.util.*;


public class PathFinder {

	
	public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_2.txt";
        
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
    		throws FileNotFoundException, IOException {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
        	lines.add(line);
        }
        reader.close();

        return parseLines(lines);    	
    }
    
    static List<String> parseLines(List<String> lines) {
    	Set<String> visited = new HashSet<String>();
    	Map<String, List<String>> graph = new HashMap<String, List<String>>();
    	List<String> res = new ArrayList<String>();
    	String[] startEnd = lines.get(0).split(" ");
    	String start = startEnd[0];
		String end = startEnd[1];
		for(int i = 1; i < lines.size(); i++) {
			String[] node = lines.get(i).trim().split(":");
			graph.put(node[0].trim(), Arrays.asList(node[1].trim().split(" ")));
		}
		backtrack(start, end, "", visited, res, graph);
		return res;
    }
    
    private static void backtrack(String s, String e, String path, Set<String> visited, List<String> res, Map<String, List<String>> graph) {
		StringBuilder cur = new StringBuilder(path);
		cur.append(s);
		visited.add(s);
		if(s.equals(e)) {
			res.add(cur.toString());
		} else {
			List<String> adjNodes = graph.get(s);
			if(adjNodes != null){
				for(String adjNode: adjNodes) {
					if(!visited.contains(adjNode)) {
						backtrack(adjNode, e, cur.toString(), visited, res, graph);
					}
				}
			}
		}
		visited.remove(s);
	}

}
