class Solution {
    
    boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
    
    
    public void Util(String s,int index,List<String> li,List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(li));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                li.add(s.substring(index,i+1));
                Util(s,i+1,li,ans);
                li.remove(li.size()-1);
            }
        }
        
        
    }
    
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        Util(s,0,new ArrayList<>(),ans);
        
        return ans;
    }
}