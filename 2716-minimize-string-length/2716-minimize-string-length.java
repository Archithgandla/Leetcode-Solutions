class Solution {
    public int minimizedStringLength(String s) {

        HashMap<Character,Boolean> hm = new HashMap<>(); 
        int count = 0;

        for(int i=0;i<s.length();i++){
            
            if(hm.containsKey(s.charAt(i)))
                continue;
            hm.put(s.charAt(i),true);
            count+=1;
        }

        return count;

    }
}