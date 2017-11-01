package test;

public class FIndPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPaths(1,3,3,0,1));
		System.out.println(Integer.MAX_VALUE);
	}
	public static int findPaths(int m, int n, int N, int i, int j) {
        int res = 0;
        if(N ==0) return res;
        if(i-1<0) {
            res++;
        } else {
            res += findPaths(m,n,N-1,i-1,j);
            res %= 1<<10+7;
        }
        if(i+1 >=n) {
            res++;
        } else {
            res += findPaths(m,n,N-1,i+1,j);
            res %= 1<<10+7;
        }
        if(j-1<0) {
            res++;
        } else {
            res += findPaths(m,n,N-1,i,j-1);
            res %= 1<<10+7;
        }
        if(j+1 >=m) {
            res++;
        } else {
            res += findPaths(m,n,N-1,i,j+1);
            res %= 1<<10+7;
        }
        return res;
    }

}
