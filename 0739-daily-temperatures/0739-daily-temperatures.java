class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //Approach-1
        //Brute Force : O(N^2) Approach
        
        //Approach-2
        //Monotonic stack
        
        
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        
        for(int i=temperatures.length-1;i>=0;i--){
            
        while(st.size()>0 && temperatures[st.peek()]<=temperatures[i])
                st.pop();
            
            if(st.size() == 0)
                ans[i] = 0;
            else
                ans[i] = st.peek()-i;
            st.push(i);
        }
        
        return ans;
        
        
    }
}






