class Solution {
    
    
    public void Util(HashMap<Character,Integer> hm,String s){
        
        
        HashMap<Character,Integer> temp = new HashMap<>();
        
        for(char c:s.toCharArray())
            temp.put(c,temp.getOrDefault(c,0)+1);
    
        ArrayList<Character> Al = new ArrayList<>();
        
        for(char c:hm.keySet()){
            
            if(!temp.containsKey(c)){
                Al.add(c);
                continue;
            }
            
            int minm = Math.min(hm.get(c),temp.get(c));
            hm.put(c,minm);
            
        }
        
        for(char c:Al)
            hm.remove(c);
        
    }
    
    
    public List<String> commonChars(String[] words) {
        
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c:words[0].toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        
        
        for(int i=1;i<words.length;i++)
            Util(hm,words[i]);
        
        
        
        
        
        List<String> Al = new ArrayList<>();
        
        for(Character c:hm.keySet()){
            
            int count = hm.get(c);
            
            while(count>0){
                Al.add(String.valueOf(c));
                count-=1;
            }
            
        }
        
        return Al;
        
    }
}