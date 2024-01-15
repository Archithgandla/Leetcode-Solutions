class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {


        //This hashmap maintains the list of loses for each player        
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();


        for(int[] arr:matches){


            //If player haven't encountered till now mark him with zero losers
            //since he is a winner in current match
            if(!hm.containsKey(arr[0]))
                hm.put(arr[0],0);

            //If player is a loser is current match increase his loses count by one
            hm.put(arr[1],hm.getOrDefault(arr[1],0)+1);
        }

        ArrayList<Integer> winners = new ArrayList<>();
        ArrayList<Integer> losers = new ArrayList<>();

        for(int k:hm.keySet()){
            if(hm.get(k) == 0)
                winners.add(k);
            else if(hm.get(k) == 1)
                losers.add(k);
        }
        Collections.sort(winners);
        Collections.sort(losers);

        ans.add(winners);
        ans.add(losers);

        return ans;

    }
}