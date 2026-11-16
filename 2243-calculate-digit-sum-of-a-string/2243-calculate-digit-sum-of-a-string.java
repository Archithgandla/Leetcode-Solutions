class Solution {
    
    public StringBuilder Util(StringBuilder s,int k){

        // System.out.println(s);

        if(s.length()<=k)
            return s;
        
        StringBuilder str = new StringBuilder("");
        int count = 0;

        for(int i=0;i<s.length();i++){

            if(i != 0 && i%k == 0){
                str.append(count);
                count = 0;
            }
            count+=((int)(s.charAt(i)-'0'));
        }
        str.append(count);

        return Util(str,k);
    }
    
    public String digitSum(String s, int k) {
        
        return Util(new StringBuilder(s),k).toString();

    }
}

