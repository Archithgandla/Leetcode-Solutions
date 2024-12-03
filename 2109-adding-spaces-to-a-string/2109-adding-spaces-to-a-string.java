class Solution {
    public String addSpaces(String s, int[] spaces) {

        //Approach-1
        //Time complexity : O(NLOGN)
        //Space complexity : O(N) for the string builder
        // Arrays.sort(spaces);
        // int j=0;
        // StringBuilder str = new StringBuilder("");

        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
            
        //     if(j<spaces.length && spaces[j] == i){
        //         str.append(' ');
        //         j+=1;
        //     }
        //     str.append(c);
        // }
        // return str.toString();


        //Approach-2
        //Time complexity : O(N)
        //Space complexity : O(N) for the hashmap and stringbuilder
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i:spaces)
            hm.put(i,1);
        StringBuilder str = new StringBuilder("");

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hm.containsKey(i))
                str.append(' ');
            str.append(c);
        }
        return str.toString();


    }
}




