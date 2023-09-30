//One of the most important questions of stack
//Monotonic stack : All the elements in stack in either in desc or ascending order

class Solution {
    public boolean find132pattern(int[] nums) {

        
        Stack<Integer> st = new Stack<>();
        int num3 = Integer.MIN_VALUE,num2 = nums[0];
        
        for(int i=nums.length-1;i>=0;i--){
            
            if(nums[i]<num3)
                return true;
            
            
            while(st.size()>0 && st.peek()<nums[i])
                num3 = st.pop();    
            
            st.push(nums[i]);
            
        }
        
        return false;
    
    }
}

