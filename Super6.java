package test;

public class Super6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="806";
		System.out.println(super6(s));
	}
	public static int super6(String s){
		if(s.length()==0) return 0;
        int cur = super6(s.substring(1));
        if(s.charAt(0)=='0') return cur+1;
        for(int i=1;i<=s.length();i++){
            String t= s.substring(0,i);
            //int divider = Integer.parseInt(t);
            int last = t.charAt(t.length()-1)-'0';
            int digitSum = 0;
            while(t.length()>1){
                digitSum +=t.charAt(0)-'0';
                if(digitSum>=10)
                    digitSum = digitSum/10 + digitSum%10;
                t = t.substring(1);
            }
            
            
            if(digitSum%3==0 &&last%2==0)
                cur++;
        }
        return cur;
    }

}
