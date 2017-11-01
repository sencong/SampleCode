package test;

public class Plus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"722/148+360/176","978/1212+183/183"};
		String[] result = fractionSum(strs);
		for(String s:result)
			System.out.println(s);

	}
	static String[] fractionSum(String[] str) {
        String[] res = new String[str.length];
        for(int i = 0;i < str.length;i++){
            String[] operands = str[i].split("\\+");
            String[] firstNum = operands[0].split("/");
            String[] secondNum = operands[1].split("/");
            int dividend0 = Integer.parseInt(firstNum[0]);
            int divisor0 = Integer.parseInt(firstNum[1]);
            int dividend1 = Integer.parseInt(secondNum[0]); 
            int divisor1 = Integer.parseInt(secondNum[1]); 
            int gcd = greatestCommonDivisor(divisor0,divisor1);
            int dividend = dividend0 *(divisor0 / gcd) + dividend1 * (divisor1 / gcd);
            int divisor = divisor0 / gcd * divisor1;
            int gcdLast = greatestCommonDivisor(dividend,divisor);
            dividend /= gcdLast;
            divisor /= gcdLast;
            res[i] = ""+dividend+"/"+divisor;
        }
        return res;
    }
    static int greatestCommonDivisor(int a ,int b){
        if(a == b) return a;
        while(a != b){
            int gcd = Math.abs(a - b);
            if(a%gcd == 0 && b%gcd ==0){
                return gcd;
            } else {
                a = Math.min(a,b);
                b = gcd;
            }
        }
        return a;
    }

}
