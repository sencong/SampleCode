package test;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPerfectNumber(28));
	}
	public static boolean checkPerfectNumber(int num) {
        int cur =2,sum =1, temp = num;
        while(cur<=temp){
            int time =1;
            while (temp%cur ==0){
                sum += Math.pow(cur,time);
                temp /= cur;
                time ++;
            }
            cur ++;
        }
        return sum ==num;
    }

}
