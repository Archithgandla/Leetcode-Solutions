class Solution {
    public int[] shuffle(int[] nums, int n) {
        //M-I : Using extra space 
        //Use two pointers and fill the elements in a new array
        
        //M-II : Without using extra space
        //Reference : https://www.youtube.com/watch?v=7HZmP8r1FBE
        //Similar to minimum swaps to sort the array problem
        
        for(int i=0;i<nums.length;i++){
            
            int currNum = nums[i];
            int currPos = i;
            
            while(currNum>0){
                int newPos = -1;
                if(currPos<n)
                    newPos = 2*currPos;
                else
                    newPos = 2*(currPos-n)+1;
                
                
                int temp = nums[newPos]; 
                nums[newPos] = -currNum;
                currNum = temp;
                currPos = newPos;
            }
            
        }
        
        for(int i=0;i<nums.length;i++)
            nums[i]*=-1;
        
        return nums;
        
    }
}