

class Solution {
    public String frequencySort(String s) {
        
//This could have worked if there are only small letters in the string
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         StringBuilder ans = new StringBuilder("");
        
//         int[] freq = new int[26];
        
//         for(int i=0;i<s.length();i++){
//             freq[s.charAt(i)-'a']+=1;       
//         }
        
//         for(int i=0;i<26;i++){
//             if(freq[i] != 0){
//                 pq.add(new Pair((char)(i+'a'),freq[i]));
//             }
//         }
        
//Since there are both small and capital letters in the string
//Use a hashmap
        
        
        HashMap<Character,Integer> hm = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        StringBuilder ans = new StringBuilder("");
        
        for(Character c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);        
        }
        
        maxHeap.addAll(hm.keySet());
        
    
        while(maxHeap.size()>0){
            
            char temp = maxHeap.remove();
            
            for(int i=0;i<hm.get(temp);i++)
                ans.append(temp);
            
        }
        
        return ans.toString();
    }
}