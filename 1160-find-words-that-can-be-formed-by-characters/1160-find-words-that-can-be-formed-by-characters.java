class Solution {
    public int countCharacters(String[] words, String chars) {
        
        
        int[] arr = new int[26];
        
        for(char c:chars.toCharArray())
            arr[c-'a']+=1;
        
        int count = 0;
        
        for(String word:words){
            
            if(word.length()>chars.length())
                continue;
            
            int[] temp = new int[26];
        
            for(char c:word.toCharArray())
                temp[c-'a']+=1;
            
            int i = 0;
            for(i=0;i<26;i++){
                if(temp[i]>arr[i])
                    break;
            }
            
            count+=(i == 26)?word.length():0;
            
        }
        
        return count;
    }
}