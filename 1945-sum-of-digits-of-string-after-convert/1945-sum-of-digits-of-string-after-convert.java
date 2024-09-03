class Solution {
    
    public int Util(int ans,int k){

        if(k == 0)
            return ans;

        int temp = 0;

        while(ans>0){
            temp+=(ans%10);
            ans/=10;
        }
        return Util(temp,k-1);
    }
    
    
    public int getLucky(String s, int k) {
        
        int ans = 0;

        for(char c:s.toCharArray()){
            int temp = (int)(c-'a')+1;
            while(temp>0){
                ans+=(temp%10);
                temp/=10;
            }
        }

        return Util(ans,k-1);

    }
}

