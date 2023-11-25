class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        
        int[] pre = new int[nums.length];
        int[] ans = new int[nums.length];
        pre[0] = 0;        
        int sum = 0;
        
        //5
        
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1]+nums[i-1];
            sum+=nums[i];
        }
        sum+=nums[0];
        
        for(int i=0;i<nums.length;i++){
            // System.out.println(sum-pre[i]-nums[i]);
            // System.out.println((nums.length-i-1)*nums[i]);
            ans[i] = Math.abs(i*nums[i]-pre[i])+Math.abs(sum-pre[i]-nums[i]-((nums.length-i-1)*nums[i]));
            //System.out.println(" ");
        }
        return ans;
        
    }
}


