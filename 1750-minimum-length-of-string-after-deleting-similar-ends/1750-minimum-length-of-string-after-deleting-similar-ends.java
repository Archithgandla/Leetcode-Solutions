class Solution {
    public int minimumLength(String s) {

        int i=0,j=s.length()-1;


        while(i<j && s.charAt(i) == s.charAt(j)){

            char temp = s.charAt(i);
            while(i<s.length() && s.charAt(i) == temp)
                i+=1;

            if(i>=j)
                return 0;
            
            while(s.charAt(j) == temp && i<j && j>0)
                j-=1;

        }

        return j-i+1;

    }
}
