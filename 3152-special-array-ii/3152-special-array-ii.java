class Solution {

    public boolean BS(ArrayList<Integer> Al,int start,int end){

        int low = 0,high = Al.size()-1;
        int mid = low+(high-low)/2;
        
        while(low<=high){
            if(Al.get(mid)>start && Al.get(mid)<=end)
                return false;
            else if(Al.get(mid)>end)
                high = mid-1;
            else
                low = mid+1;
            mid = low+(high-low)/2;
        }

        return true;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        ArrayList<Integer> Al = new ArrayList<>();

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]%2 == nums[i]%2)
                Al.add(i);
        }

        //System.out.println(Al);

        boolean[] ans = new boolean[queries.length];

        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];

            if(BS(Al,query[0],query[1]))
                ans[i] = true;
        }
        
        return ans;
    }
}






