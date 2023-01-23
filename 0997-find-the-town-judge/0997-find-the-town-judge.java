class Solution {
    public int findJudge(int n, int[][] trust) {
        //Celebrity Problem
        //Usage of stack
        
        int[][] arr = new int[n+1][n+1];        
        
        for(int[] temp:trust)
            arr[temp[0]][temp[1]] = 1;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=1;i<=n;i++)
            st.push(i);
        
        
        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            
            //a is judge
            if(arr[a][b] != 1 && arr[b][a] == 1){
                st.push(a);
                //System.out.println(b);
            }
            //b is judge
            if(arr[b][a] != 1 && arr[a][b] == 1){
                //System.out.println(a);
                st.push(b);
            }
        }
        
        if(st.size() == 0)
            return -1;
        
        int pot = st.pop();
        
        for(int i=1;i<=n;i++){
            if(arr[pot][i] == 1)
                return -1;
        }
        
        for(int i=1;i<=n;i++){
            if(arr[i][pot] == 0 && i!=pot)
                return -1;
        }
        
        return pot;
        

    }
}