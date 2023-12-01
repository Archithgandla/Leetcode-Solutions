class Solution {
    
    
    //Approach - 2
    //Constant space
    //Time : O(Total number of characters)
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0,j=0;
        
        String a = word1[i],b = word2[i];
        int p=0,q = 0;
        
        //loop runs until one of the arrays exhaust
        //For true condition both of them should get exhautsed
        while(i<word1.length && j<word2.length){
            
            while(p<a.length() && q<b.length()){
                
                if(a.charAt(p) != b.charAt(q))
                    return false;
            
                p+=1;
                q+=1;
                
                // System.out.println("p : "+p);
                // System.out.println("q : "+q);
            }
            //System.out.println("Hi");
            
            //If word in word1 has exhausted
            if(p==a.length()){
                i+=1;
                
                if(i<word1.length){
                    p = 0;
                    a = word1[i];
                }
            
            }

            //If word in word2 has exhausted
            if(q>=b.length()){
                
                j+=1;
                
                if(j<word2.length){
                    q = 0;
                    b = word2[j];
                }
            }
      
        }
        
        //If one the words in one of the arrays is not used compeletely but the array exhausted that means two strigs are not same
        if(p<a.length() || q<b.length())
            return false;
        
        return true;
    }
}