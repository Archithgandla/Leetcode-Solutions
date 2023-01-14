class Solution {

    //performance can be improved using Union and find
    char DFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int v,char c){
        
        visited[v] = true;

        if((char)(v+'a')<c){
            //System.out.println((char)(v+'a'));
            c = (char)(v+'a');
        }
        for(int i:adj.get(v)){
            if(!visited[i]){
                //System.out.println((char)(i+'a')<'p');
                c = DFS(adj,visited,i,c);
            }
        }
        return c;
    }


    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<26;i++)
            adj.add(new ArrayList<>());
        
        //Creating a adjacency list
        for(int i=0;i<s1.length();i++){
            adj.get(s1.charAt(i)-'a').add(s2.charAt(i)-'a');
            adj.get(s2.charAt(i)-'a').add(s1.charAt(i)-'a');
        }

        //System.out.println(adj);

        StringBuilder ans = new StringBuilder("");

        for(int i=0;i<baseStr.length();i++){
            char c = DFS(adj,new boolean[26],baseStr.charAt(i)-'a',baseStr.charAt(i));
            ans.append(c);
        }
        return ans.toString();
    }
}