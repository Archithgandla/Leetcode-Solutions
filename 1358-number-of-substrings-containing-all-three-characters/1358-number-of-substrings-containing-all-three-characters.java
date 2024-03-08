class Solution {
    public int numberOfSubstrings(String s) {
        
        //Approach-1
        //Generate all the substrings
        
        //Approach-2
        
        int i=0,j=0,a=0,b=0,c=0,ans=0;
        
            
        while(i<s.length() && j<s.length()){
            
            
            if(s.charAt(j) == 'a')
                a+=1;
            else if(s.charAt(j) == 'b')
                b+=1;
            else
                c+=1;
            
            
            if(a<=0 || b<=0 || c<=0){
                j+=1;
                continue;
            }
            
            
            int temp = 0;
            
            while(a>0 && b>0 && c>0 && i<j){
                
                temp+=1;
                if(s.charAt(i) == 'a')
                    a-=1;
                else if(s.charAt(i) == 'b')
                    b-=1;
                else
                    c-=1;
                
                i+=1;
            }
            
            ans+=(temp*(s.length()-j));
            j+=1;
            
        }
        
        
        return ans;
                
    }
    

}