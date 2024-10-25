class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder,(a,b) -> a.length()-b.length());
        HashMap<String,Integer> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        //System.out.println(Arrays.toString(folder));

        for(String f:folder){
            
            String temp = "";

            for(char c:f.toCharArray()){
                //System.out.println(temp);
                if(c == '/' && hm.containsKey(temp))
                    break;
                temp+=c;
            }

            if(temp.length() != f.length())
                continue;
            //System.out.println(hm);
            ans.add(temp);
            hm.put(temp,1);
        }
        //System.out.println(hm);
        return ans;
    }
}