class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        StringBuilder str = new StringBuilder("");
        HashMap<String,Integer> hm = new HashMap<>();
        int count = 0;

        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            if(c != ' '){
                str.append(c);
                continue;
            }   
            hm.put(str.toString(),hm.getOrDefault(str.toString(),0)+1);
            str = new StringBuilder("");
        }
        hm.put(str.toString(),hm.getOrDefault(str.toString(),0)+1);
        str = new StringBuilder("");

        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(c != ' '){
                str.append(c);
                continue;
            }   
            hm.put(str.toString(),hm.getOrDefault(str.toString(),0)+1);
            str = new StringBuilder("");
        }
        hm.put(str.toString(),hm.getOrDefault(str.toString(),0)+1);

        for(String key:hm.keySet())
            count+=(hm.get(key) == 1?1:0);

        String[] ans = new String[count];
        System.out.println(hm);
        count-=1;

        for(String key:hm.keySet()){
            if(hm.get(key) != 1)
                continue;
            ans[count--] = key;
        }
    
        return ans;

    }
}