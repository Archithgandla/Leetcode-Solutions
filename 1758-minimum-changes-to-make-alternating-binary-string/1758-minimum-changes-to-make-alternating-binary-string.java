class Solution {
    public int minOperations(String s) {
        
        //Approach-1
        //Recursion approach
        //For each character there are two possibilities
        //Flip or non flip
        //start from index0 and till you reach index s.length()
        //Now check wheter alternate string is formed
        //If yes compare it with global minimum variable
        
        
        
        //Approach-2
        //We need to make the alternate characters different
        //For this two patterns exists based on the first character
        //i.e starting with 0 -> 0101010101.....
        //or else starting with 1 -> 10101010101.....
        //Consider both the possibilities and take the minimum
        
        
        char prev = s.charAt(0);
        int count1 = 0,count2 = 0;
        
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) != prev)
                prev = s.charAt(i);
            else{
                prev = s.charAt(i) == '0'?'1':'0';
                count1+=1;
            }
        }
        
        prev = s.charAt(0) == '0'?'1':'0';
        count2+=1;
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) != prev)
                prev = s.charAt(i);
            else{
                prev = s.charAt(i) == '0'?'1':'0';
                count2+=1;
            }
        }
        
        
        
        return Math.min(count1,count2);
        
    }
}