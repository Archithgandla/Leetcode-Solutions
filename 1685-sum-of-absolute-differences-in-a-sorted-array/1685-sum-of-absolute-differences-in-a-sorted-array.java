class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        
        //Approach-1
        //Use a nested loop and for each outer iteration calculate the difference of current element
        //with of all other elements using inner loop
        
        
        //Approach-2
        //Since the array is an non decreasing array
        //Instead of calculating difference seperately
        //We can just calculate the sum of elements to the left and right of current element
        //and calculate difference directly
    
        //This comes from the property
        //|a| is a if a is positive
        //|a| is -a if a is positive
        
        //|a| + |b| can be written as a+b if 
        //a<0 and b<0 or
        //a>0 and b>0
        
        
        int[] pre = new int[nums.length];
        int[] ans = new int[nums.length];
        pre[0] = 0;        
        int sum = 0;
        
        
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1]+nums[i-1];
            sum+=nums[i];
        }
        sum+=nums[0];
        
        for(int i=0;i<nums.length;i++)
            ans[i] = (i*nums[i]-pre[i])+(sum-pre[i]-nums[i]-((nums.length-i-1)*nums[i]));
        
        return ans;
        
    }
}


