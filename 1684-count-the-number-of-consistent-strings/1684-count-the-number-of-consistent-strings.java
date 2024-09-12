class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        HashMap<Character,Integer> hm = new HashMap<>();

        for(char c:allowed.toCharArray())
            hm.put(c,1);

        int count = 0;
        for(String str:words){

            int i=0;
            for(;i<str.length();i++){
                char c = str.charAt(i); 
                if(!hm.containsKey(c))
                    break;
            }
            if(i == str.length())
                count+=1;
        }

        return count;

    }
}




