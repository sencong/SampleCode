package test;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("0110"));
	}
	public static int numDecodings(String s) {
        if(s.length() ==0 ) return 0;
        //if(s.length() ==1 ) return s.charAt(0) == '0'? 0 :1;
        int oldCount = 1;
        int newCount = s.charAt(0) == '0'? 0 :1;
        int cur = newCount;
        for(int i = 2;i<=s.length();i++){
            cur = s.charAt(i-1) == '0'? 0:newCount;
            int twoDigit = (s.charAt(i-2) - '0')*10+s.charAt(i-1) - '0';
            if(twoDigit>=10 && twoDigit <=26) cur += oldCount;
            oldCount = newCount;
            newCount = cur;
            
        }
        return cur;
    }
}
