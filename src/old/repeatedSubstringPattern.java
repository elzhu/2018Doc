package old;

public class repeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if(s==null || s.length()==0)
            return false;

        return checkEven(s) || checkOdd(s);
    }

    public boolean checkOdd(String s) {
        int len=s.length();
        return len%2==0 && s.substring(0, len/2).equals(s.substring(len/2, len));
    }

    public boolean checkEven(String s) {
        int len=s.length();
        top : for(int n=3; n<=len; n+=2){
            if(len%n==0){
                int m=len/n;
                StringBuilder sb=new StringBuilder();
                String seg=s.substring(0,m);
                for(int i=0; i<len; i+=m){
                    if(!seg.equals(s.substring(i,i+m)))
                        continue top;
                    sb.append(seg);
                }
                if(s.equals(sb.toString()))
                    return true;
            }
        }
        return false;
    }
}
