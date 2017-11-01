package test;
import java.util.*;
class ListNode{
	int val;
	ListNode next;
	ListNode(int a){
		val = a;
	}
}

public class CourseScheduleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,0},{0,1}};
		int[] b = findOrder(a.length,a);
		for(int c:b)
			System.out.println(c);
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites)
            graph.get(pair[1]).add(pair[0]);
        
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            Arrays.fill(onPath, false);
            if(!topoSort(res, graph, visited, onPath, i)) 
                return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    //the return value of this function only contains the ifCycle info and does not interfere dfs process. if there is Cycle, then return false
    private static boolean topoSort(List<Integer> res, List<List<Integer>> graph, boolean[] visited, boolean[] onPath, int i){
        if(visited[i])
            return onPath[i] ? false : true;
        visited[i] = true;
        
        for(int j : graph.get(i)){
            if(!topoSort(res, graph, visited, onPath, j)) 
                return false;
        }
        onPath[i] = false;
        res.add(i);//the only difference with traversing a graph
        return true;
    }
}
