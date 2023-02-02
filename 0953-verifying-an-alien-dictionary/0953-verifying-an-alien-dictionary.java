class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<order.length();i++)
            hm.put(order.charAt(i),i);
        
        
        for(int i=0;i<words.length-1;i++){
            int j=0,k=0;
            String w1 = words[i];
            String w2 = words[i+1];
            
            while(j<w1.length() || k<w2.length()){
                if(j == w1.length()  || (k<w2.length() && hm.get(w1.charAt(j))<hm.get(w2.charAt(k))))
                    break;
                if(k == w2.length() || hm.get(w1.charAt(j))>hm.get(w2.charAt(k)))
                    return false;
                j+=1;
                k+=1;
            }
            
        }
        return true;
            
    }
}