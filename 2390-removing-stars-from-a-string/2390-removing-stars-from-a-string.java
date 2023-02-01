class Solution {
    public String removeStars(String s) {

//M-I
//         Stack<Character> st = new Stack<>();
        
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i) != '*')
//                 st.push(s.charAt(i));
//             else{
//                 st.pop();
//             }
//         }
        
//         StringBuilder ans = new StringBuilder();
        
//         while(st.size()>0)
//             ans.append(st.pop());
        
//         return ans.reverse().toString();
        
//M-II
        StringBuilder str = new StringBuilder("");            
        
        for(char c:s.toCharArray()){
            if(c == '*')
                str.deleteCharAt(str.length()-1);
            else
                str.append(c);
        }
        return str.toString();
    }
}