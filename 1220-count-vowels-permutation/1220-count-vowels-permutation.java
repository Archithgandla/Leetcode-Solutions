class Solution {

    char[] vowels = new char[]{'a','e','i','o','u'};
    HashMap<Character,Integer> hm = new HashMap<>();

    public long Util(int n,char prev,long[][] dp){

        if(n == 0)
            return 1;

        if(dp[n][hm.get(prev)] != -1){
            //System.out.println("Hey");
            return dp[n][hm.get(prev)];
        }

        //System.out.println(prev);
        long count = 0;

        if(prev == 'a')
            count = (count+Util(n-1,'e',dp))%(int)(1e9+7);

        else if(prev == 'e'){
            count = (count+Util(n-1,'a',dp))%(int)(1e9+7);
            count = (count+Util(n-1,'i',dp))%(int)(1e9+7);
        }

        else if(prev == 'i'){

            for(char c:vowels){
                
                if(c == 'i')
                    continue;
                
                count = (count+Util(n-1,c,dp))%(int)(1e9+7);
            }
        }


        else if(prev == 'o'){
            count = (count+Util(n-1,'i',dp))%(int)(1e9+7);
            count = (count+Util(n-1,'u',dp))%(int)(1e9+7);
        }

        else if(prev == 'u')
            count = (count+Util(n-1,'a',dp))%(int)(1e9+7);

        return dp[n][hm.get(prev)] = count;

    }



    public int countVowelPermutation(int n) {

        long count = 0;
        long[][] dp = new long[(int)2e4][5];

        for(long[] arr:dp)
            Arrays.fill(arr,-1);


        hm.put('a',0);
        hm.put('e',1);
        hm.put('i',2);
        hm.put('o',3);
        hm.put('u',4);


        for(char c:vowels)
            count = (count+Util(n-1,c,dp))%(int)(1e9+7);

        return (int)(count);
    }
}







