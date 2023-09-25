class Solution {
    public char findTheDifference(String s, String t) {

        int[] freq = new int[26];

        for(char c:t.toCharArray())
            freq[c-'a']+=1;

        for(char c:s.toCharArray())
            freq[c-'a']-=1;


        for(int i=0;i<26;i++){
            if(freq[i]>0)
                return (char)('a'+i);
        }

        return '0';
    }
}









