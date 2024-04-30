class Solution {
    public long wonderfulSubstrings(String word) {
        

        //Watch https://www.youtube.com/watch?v=1DdmbJj4xLE
        //For Approach

        int curr = 0;
        long ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);

        for(char c:word.toCharArray()){

            int shift = (int)(c-'a');
            int temp = 1<<shift;

            curr = curr^temp;
            
            ans+=hm.getOrDefault(curr,0);

            for(int i=0;i<=25;i++){
                ans+=(hm.getOrDefault(curr^(1<<i),0));
            }
            hm.put(curr,hm.getOrDefault(curr,0)+1);

            //System.out.println(ans);

        }

        return ans;

    }
}


