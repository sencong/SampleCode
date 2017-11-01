package test;

public class Funny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0;i < 1;i++){
            String str = "acxz";
            int len = str.length();
            boolean isFunny = true;
            for(int j = 0;j < len-1;j++){
                isFunny = true;
                int a = Math.abs(str.charAt(j)-str.charAt(j+1));
                int b = Math.abs(str.charAt(len - 1 -j) - str.charAt(len - 2 - j));
                if(a != b){
                    System.out.println("Not Funny");
                    isFunny = false;
                    break;   
                }
            }
            if(isFunny){
                System.out.println("Funny");
            }
        }
	}

}
