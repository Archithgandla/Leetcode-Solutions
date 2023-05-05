class Solution {
    
    boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
    
    
    public int maxVowels(String s, int k) {
        
        int i=0,j=0;
        int count = 0,ans = Integer.MIN_VALUE;

        while(j<k && j<s.length()){
            count+=isVowel(s.charAt(j))?1:0;
            j+=1;
        }

        ans = Math.max(ans,count);
        while(j<s.length()){
            count-=(isVowel(s.charAt(i)))?1:0;
            i+=1;
            count+=(isVowel(s.charAt(j)))?1:0;

            ans = Math.max(ans,count);
            //System.out.println(ans+" "+count);
            j+=1;
        }
        return ans;

    }
}


