class Solution {
    
    
    public void Util(int index,String str,HashMap<String,Integer> hm,List<String> ans,String s){

        if(index == str.length()){
            ans.add(new String(s.substring(1)));
            return;
        }

        String temp = "";

        for(int i=index;i<str.length();i++){

            temp+=(str.charAt(i));

            if(hm.containsKey(temp))
                Util(i+1,str,hm,ans,s+" "+temp);
        }
        return;
    }
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {    
        
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();

        for(String temp:wordDict)
            hm.put(temp,1);

        Util(0,s,hm,ans,"");

        return ans;
    }
}





