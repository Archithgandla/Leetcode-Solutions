class Solution {
    public int numOfSubarrays(int[] arr) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        long count = 0,sum = 0,MOD = 1000000007;

        for(int num:arr){
            sum+=num;

            if(sum%2 == 1)
                count = (count+hm.getOrDefault(0,0)+1)%MOD;
            else
                count = (count+hm.getOrDefault(1,0))%MOD;

            int key = (int)(sum%2);
            hm.put(key,hm.getOrDefault(key,0)+1);
        }

        return (int)count;        
    }
}

