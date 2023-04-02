class Solution {

    int upper_bound(int[] arr,long x){
        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;
        int ans = -1;

        while(low<=high){
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }
            else{ 
                low = mid+1;
            }
            mid = low+(high-low)/2;
        }
        return ans;
    }



    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];

        for(int i=0;i<spells.length;i++){
            long temp = (long)success%spells[i] == 0?(long)success/spells[i]:
            (long)(success/spells[i])+1;
            
            int ub = upper_bound(potions,temp);
            //System.out.println(spells[i]+" "+temp+" "+(potions.length-ub));
            ans[i] = ub != -1?potions.length-ub:0;
        }
        return ans;
    }
}