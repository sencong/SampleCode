package test;

import java.util.HashSet;
import java.util.Set;

public class Uncommon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaa",b="aaa";
		System.out.println(findLUSlength(a, b));
	}
	public static int findLUSlength(String a, String b) {
        String min = a.length()<b.length()? a:b;
        String max = a.length()<b.length()? b:a;
        for(int i = min.length();i>=0;i--){
            Set<String> set = new HashSet<>();
            for(int j=0;j<=min.length()-i;j++)
                set.add(min.substring(j,j+i));
            for(int j=0;j<=max.length()-i;j++){
                if(set.contains(max.substring(j,j+i))) break;
            }
            return i;
        }
        return -1;
    }

}
