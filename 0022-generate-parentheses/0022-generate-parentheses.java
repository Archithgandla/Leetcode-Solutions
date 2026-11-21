class Solution {
    
    public void Util(int open,int close,StringBuilder str,List<String> ans){

        if(open == 0 && close == 0){
            ans.add(str.toString());
            return;
        }

        if(open>0){
            str.append('(');
            Util(open-1,close,str,ans);
            str.deleteCharAt(str.length()-1);
        }

        if(close>open){
            str.append(')');
            Util(open,close-1,str,ans);
            str.deleteCharAt(str.length()-1);    
        }

        return;
    }    

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<String>();

        Util(n,n,new StringBuilder(""),ans);

        return ans;
    }
}

