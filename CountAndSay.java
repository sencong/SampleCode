package test;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(3));

	}
	public static String countAndSay(int n) {
        StringBuffer s = new StringBuffer("1");
        StringBuffer buff = new StringBuffer();
        while((--n) != 0){
            buff.setLength(0);
            int size = s.length();
            int cnt = 1;
            char cur = s.charAt(0);
            for(int i=1;i<size;i++){
                if(s.charAt(i)!=cur){
                    buff.append(cnt);
                    buff.append(cur);
                    cur = s.charAt(i);
                    cnt = 1;
                }else ++cnt;
            }
            buff.append(cnt);
            buff.append(cur);
            StringBuffer tmp = s;
            s = buff;
            buff = tmp;
        }
        return s.toString();
    }

}
