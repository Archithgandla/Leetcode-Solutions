class Solution {
    
    
    public void Util(int idx,int[] ans,int target){

        if(target == 0)
            return;

        for(int i=5;i>=1;i--){
            if(i>target)
                continue;
            
            ans[idx] = 6-i;
            Util(idx+1,ans,target-i);
            break;
        }

    }
    
    
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int mSum = 0,target = -1;

        for(int i:rolls)
            mSum+=i;
        target = (mean*(n+rolls.length))-mSum;

        if(target>n*6 || target<n)
            return new int[0];

        int[] ans = new int[n];
        Arrays.fill(ans,6);
        Util(0,ans,(n*6)-target);

        return ans;
    }
}