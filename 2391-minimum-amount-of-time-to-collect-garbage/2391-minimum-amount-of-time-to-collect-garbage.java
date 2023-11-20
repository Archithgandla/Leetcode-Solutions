class Solution {
        
    public int garbageCollection(String[] garbage, int[] travel) {
        
        //Finding the last house for each type of garbage

        int g = -1,p = -1,m = -1,ans = 0;
        int[] last = new int[3];
        
        for(int i=0;i<garbage.length;i++){
            
            String str = garbage[i];
            ans+=(str.length());
            
            for(char c:str.toCharArray()){
                
                if(c == 'G')
                    last[0] = i;
                if(c == 'P')
                    last[1] = i;
                if(c == 'M')
                    last[2] = i;
            }
                    
        }
        
        for(int i=1;i<garbage.length;i++){
            
            int factor = 0;
            
            if(last[0]>=i)
                factor+=1;
            if(last[1]>=i)
                factor+=1;
            if(last[2]>=i)
                factor+=1;
            
            ans+=(factor*travel[i-1]);
        }
        
        
        
        return ans;
        
    }
}







