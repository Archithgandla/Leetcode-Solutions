
class Pair{
    int score;
    int age;

    Pair(int score,int age){
        this.age = age;
        this.score = score;
    }
}


class Solution {

    public int Util(Pair[] arr,int prev,int index,int[][] dp){
        if(index<0)
            return 0;

        if(dp[index][prev+1] != -1)
            return dp[index][prev+1];

        int ans = Integer.MIN_VALUE;
        
        //Take
        if(prev == -1 || arr[index].score<=arr[prev].score)
            ans = Math.max(ans,arr[index].score+Util(arr,index,index-1,dp));
        
        //Not take
        ans = Math.max(ans,Util(arr,prev,index-1,dp));
        return dp[index][prev+1] = ans;
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        Pair[] arr = new Pair[scores.length];

        for(int i=0;i<scores.length;i++)
            arr[i] = new Pair(scores[i],ages[i]);      
        Arrays.sort(arr,(a,b)->a.age == b.age?a.score-b.score:a.age-b.age);

        int[][] dp = new int[scores.length][scores.length+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                dp[i][j] = -1;
        }

        return Util(arr,-1,scores.length-1,dp);
    }
}