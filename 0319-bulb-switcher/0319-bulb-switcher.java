class Solution {
    public int bulbSwitch(int n) {
        //Approach-1
        
        int i = 1;
        for(i=1;i*i<=n;i++);
        
        return i-1;
        
    }
}


//Approach-1 : Not Working
//         boolean[] flag = new boolean[n+1];
//         Arrays.fill(flag,true);
        
        
//         for(int i=2;i<=n/2;i++){
                   
//             int curr = i;
//             int j=1;        
        
//             while(curr*j<=n){
//                 flag[curr*j] = !flag[curr*j];
//                 j+=1;
//             }
    
                        
//         }
        
//         int count = 0;
        
//         for(boolean temp:flag)
//             count+=(temp)?1:0;
//         return count-1;