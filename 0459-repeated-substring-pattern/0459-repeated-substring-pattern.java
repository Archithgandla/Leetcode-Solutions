class Solution {


    boolean Util(String s,String substr,int size){

        int start = size;

        System.out.println(substr);
        while(start<s.length()){

            if(!s.substring(start,start+size).equals(substr))
                return false;
            start+=size;
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        
        //M-I
        //consider substrings of all sizes from 1 to (size of string)
        //check if any of that substrings in repeating
        //Will give TLE for sure
        //TC of n^2

        //M-II
        for(int i=s.length()/2-1;i>=0;i--){
            if(s.length()%(i+1) == 0 && Util(s,s.substring(0,i+1),i+1))
                return true;
        }
        return false;
    }
}