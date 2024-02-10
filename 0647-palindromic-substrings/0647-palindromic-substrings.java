class Solution {

    public boolean isPalindrome(String s,int i,int j,int[][] dp){

        if(i>=j)
            return true;
        
        if(dp[i][j] != -1){
            //System.out.println("Hey");
            return dp[i][j] == 1;
        }
        if(s.charAt(i) == s.charAt(j)){
            boolean temp = isPalindrome(s,i+1,j-1,dp);

            dp[i][j] = temp?1:0;

            return temp;

        }
        dp[i][j] = 0;

        return false;

    }


    public int countSubstrings(String s) {

        //Approach-1
        //Consider all the suubstrings using nested loop and then
        //check if they are palindrome
        //O(N3)

        
        int count = 0;
        int[][] dp = new int[s.length()][s.length()];

        for(int[] arr:dp)
            Arrays.fill(arr,-1);

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                
                if(isPalindrome(s,i,j,dp))
                    count+=1;
            }
        }

        return count;


        //Approach-2
        //https://www.youtube.com/watch?v=tGAMyZxlwuA
        //best approach
    


    }
}




