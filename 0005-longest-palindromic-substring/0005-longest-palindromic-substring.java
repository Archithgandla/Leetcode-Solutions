class Solution {

    public Boolean isPalindrome(String str,int start,int end,int[][] dp){
        
        if(start>=end)
            return true;

        if(dp[start][end] != -1)
            return dp[start][end] == 1;

        if(str.charAt(start) != str.charAt(end))
            return false;

        dp[start][end] = isPalindrome(str,start+1,end-1,dp)?1:0;

        return dp[start][end] == 1; 
    }


    public String longestPalindrome(String s) {

        //Approach - 1
        //Check the property of palindorme for all the possible substrings
        //Time complexity : O(n^3)

        //Optimization for above approach : 
        //Overlapping subproblems are occuring when we are calling palindrome function multuiple times
        //like 2,5 and 1,3
        //which can be optimized using memoization
        //Refer codestory with mik

        //Try referring striver for longest common subsequence approach

        if(s.length() == 1)
            return s;

        String ans = "";
        int[][] dp = new int[s.length()][s.length()];

        for(int[] arr:dp)
            Arrays.fill(arr,-1);



        for(int i=0;i<s.length();i++){

            for(int j=i;j<s.length();j++){

                    //System.out.println(i+" "+j+" "+isPalindrome(s,i,j));
                    if(isPalindrome(s,i,j,dp) && j-i+1>ans.length()){
                        //System.out.println(s.substring(i,j+1)+" "+" hello");
                        ans = s.substring(i,j+1);
                    }


            }
        }

        return ans;
    }
}








