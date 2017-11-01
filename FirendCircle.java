package test;

public class FirendCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(findCircleNum(M));
	}
	public static int findCircleNum(int[][] M) {
        int N = M.length;
        int[] root = new int[N];
        int count =N;
        for(int i = 0;i<N;i++){
            root[i] =i;
        }
        for(int i=0;i<N;i++){
            for(int j =i+1;j<N;j++){
                if(M[i][j]==1){
                    int r = findRoot(root,i);
                    int f = findRoot(root,i);
                    
                    if(f!=r){
                        root[j] =r;
                        count --;
                    }
                    
                }
            }
        }
        return count;
    }
    private static int findRoot(int[] roots,int test){
        while(test!=roots[test]) {
            roots[test] = roots[roots[test]];
            test = roots[test];
        }
        return test;
    }

}
