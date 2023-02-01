//Other approaches
//Brute force
//https://www.youtube.com/watch?time_continue=258&v=-S_dMwpy8NM&embeds_euri=https%3A%2F%2Fleetcode.com%2F&source_ve_path=MjM4NTE&feature=emb_title


//Explanation
//https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3124940/c-one-line-beats-100-runtime-explanation/

class Solution {
    int GCD(int a,int b){
        int min = Math.min(a,b);

        while(min>1){
            if(a%min == 0 && b%min == 0)
                return min;
            min-=1;
        }
        return 1;
    }

    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1))
            return str1.substring(0,GCD(str1.length(),str2.length()));
        return "";
    }
}