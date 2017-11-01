package test;

public class H {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3,"apz","zpa"));
	}
	static int solution(int n, String s, String t) {
        int res = 0;
        for(int i = 0;i < n;i++){
            res += minStrokes(s.charAt(i),t.charAt(i));
        }
        return res;
    }
    static int minStrokes(char a, char b){
        int move = Math.abs(a-b);
        int moveLeft= a-'a' +1 + 'z' -b;
        //int moveRight = 
        return Math.min(move,moveLeft);
    }

}
