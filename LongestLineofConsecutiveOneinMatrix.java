package test;

public class LongestLineofConsecutiveOneinMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
		System.out.println(longestLine(M));
	}
	public static int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int row = M.length, col = M[0].length;
        int[][] visited = new int[row][col];
        int res = 0, counter = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; i< col; j++) {
                if (M[i][j] == 0)
                    continue;
                if ((visited[i][j] >> 3 & 1) == 0) {
                    counter = 0;
                    int j1 = j;
                    while (j1 < col && M[i][j1] == 1 && (visited[i][j1] >> 3 & 1) == 0) {
                        counter ++;
                        j1 ++;
                    }
                    res = Math.max(res, counter);
                }
                if ((visited[i][j] >> 2 & 1) == 0) {
                    counter = 0;
                    int i2 = i;
                    while (i2 < row && M[i2][j] == 1 && (visited[i2][j] >> 2 & 1) == 0) {
                        counter ++;
                        i2 ++;
                    }
                    res = Math.max(res, counter);
                }
                if ((visited[i][j] >> 1 & 1) == 0) {
                    counter = 0;
                    int i3 = i, j3 = j;
                    while (i3 < row && j3 >= 0 && M[i3][j3] == 1 && (visited[i3][j3] >> 1 & 1) == 0) {
                        counter ++;
                        i3 ++;
                        j3 --;
                    }
                    res = Math.max(res, counter);
                }
                if ((visited[i][j] >> 0 & 1) == 0) {
                    counter = 0;
                    int i4 = i, j4 = j;
                    while (i4 < row && j4 < col && M[i4][j4] == 1 && (visited[i4][j4] >> 0 & 1) == 0) {
                        counter ++;
                        i4 ++;
                        j4 ++;
                    }
                    res = Math.max(res, counter);
                }
            }
        }
        return res;
    }

}
