class Solution {
    
    int Util(char[] vowel,int n,int prev_index){
        if(n == 0)
            return 1;
        
        int count = 0;
        
        for(int i=prev_index;i<vowel.length;i++){
            count+=(Util(vowel,n-1,i));
        }
        return count;
    }
    
    public int countVowelStrings(int n) {
        char[] vowel = new char[]{'a','e','i','o','u'};
        
        return Util(vowel,n,0);
    }
}