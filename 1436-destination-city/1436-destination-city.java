class Solution {
    public String destCity(List<List<String>> paths) {
        
        
        HashMap<String,Boolean> hm = new HashMap<>();
        
        for(List<String> li:paths){
            
                hm.put(li.get(0),false);
            
            if(!hm.containsKey(li.get(1)))
                hm.put(li.get(1),true);
        }        
        
        for(String str:hm.keySet()){
            
            if(hm.get(str))
                return str;
        }
        
        return "";
    }
}


