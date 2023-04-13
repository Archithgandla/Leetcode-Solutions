class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0,j=0;
        
        while(i<pushed.length && j<popped.length){
            
            while(i<pushed.length && (st.size() == 0 || (st.peek() != popped[j]))){
                st.push(pushed[i]);
                i+=1;
            }
            
            st.pop();
            j+=1;
        }
        
        
        while(j<popped.length){
            if(st.pop() != popped[j])
                return false;
            j+=1;
        }
        return true;
        
    }
}