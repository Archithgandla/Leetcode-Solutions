class Solution {
    public boolean isPowerOfTwo(int n) {
        
        //Taken long to make sure that it doesnot overflow become negative
        //and lead to infinite loop
        
        long x = 1;
        
        while(x<=n){
            
            if(x == n)
                return true;
            
            x = (x<<1);
        }
        
        return false;
        
        
        //Better approaches
        //https://www.youtube.com/watch?v=bVfA6_rDw4M
        
    }
}