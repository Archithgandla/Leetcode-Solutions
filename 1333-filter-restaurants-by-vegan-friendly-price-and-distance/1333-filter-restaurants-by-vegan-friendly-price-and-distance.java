class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        

        List<int[]> Al = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int[] temp:restaurants){

            if(veganFriendly == 1 && temp[2] == 0)
                continue;
            
            if(temp[3]<=maxPrice && temp[4]<=maxDistance)
                Al.add(temp);
        }

        Collections.sort(Al,(a,b) -> a[1] == b[1]?b[0]-a[0]:b[1]-a[1]);

        for(int[] temp:Al)
            ans.add(temp[0]);

        return ans;

    }
}


