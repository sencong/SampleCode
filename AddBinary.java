package test;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1" , b = "111";
		System.out.println(addBinary(a,b));
	}
	public static String addBinary(String a, String b) {
		int sum = 0;
        int last1 = a.length()-1;
        int last2 = b.length()-1;
        StringBuilder resRev = new StringBuilder();
        while(last1 >=0 || last2 >=0 || sum ==1){
            if(last1 >=0){
                sum += a.charAt(last1) - '0';
                last1 --;
            }
            if(last2 >=0){
                sum += a.charAt(last2) - '0';
                last2 --;
            }
            resRev.append(sum % 2);
            sum >>= 1;
        }
        return resRev.reverse().toString();
    }

}
