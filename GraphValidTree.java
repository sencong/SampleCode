package test;

public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0,1},{2,0},{0,3},{4,1}};
		System.out.println(validTree(5,edges));
	}
	public static boolean validTree(int n, int[][] edges) {
		class UnionFind {
      	  int[] roots;
      	  UnionFind(int n){
      	    roots = new int[n];
      	    for(int i =0 ;i <n; i++){
      	      roots[i] = i; 
      	    }  
      	  }
      	  int find(int i){
      	    if(roots[i] == i) 
      	        return i;
      	    roots[i] = find(roots[i]);
      	    return roots[i];
      	  }
      	  boolean union(int p , int q){
      	    int rootp = find(p);
      	    int rootq = find(q);
      	    if(rootp == rootq){
      	      return false; 
      	    } else {
      	       //roots[rootp] = Math.min(rootp,rootq);
      	       //roots[rootq] = Math.min(rootp,rootq);  
      	      roots[rootq] = rootp;  
      	      return true;
      	    }
      	  }
      	  
      	}
		
        UnionFind tree = new UnionFind(n);
        if(edges.length != n -1) return false;
        for(int[] edge: edges){
            if(!tree.union(edge[0],edge[1])){
              return  false;
            }
        }
        return true;
        
    }

}
