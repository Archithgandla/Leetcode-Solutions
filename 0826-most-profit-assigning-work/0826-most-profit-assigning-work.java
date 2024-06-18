
class Pair{
    int difficulty,profit;

    Pair(int difficulty,int profit){
        this.difficulty = difficulty;
        this.profit = profit;
    }
}


class Solution {

    public int BS(Pair[] arr,int target){

        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;
        int ans = -1;

        while(low<=high){

            if(arr[mid].difficulty<=target){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid].difficulty>target)
                high = mid-1;
            mid = low+(high-low)/2;

        }
        return ans;
    }


    public int maxProfitAssignment(int[] difficulty,int[] profit,int[] worker) {

        Pair[] arr = new Pair[difficulty.length];
        
        for(int i=0;i<arr.length;i++)
            arr[i] = new Pair(difficulty[i],profit[i]);
        
        Arrays.sort(arr,(a,b) -> a.difficulty-b.difficulty);

        int[] prefix = new int[profit.length];
        int maxm = Integer.MIN_VALUE;
        
        for(int i=0;i<profit.length;i++){
            maxm = Math.max(maxm,arr[i].profit);
            prefix[i] = maxm;
        }

        //System.out.println(Arrays.toString(prefix));

        int ans = 0;

        for(int i:worker){
            int idx = BS(arr,i);

            if(idx == -1)
                continue;
            ans+=(prefix[BS(arr,i)]);
            //System.out.println(ans);
        }

        return ans;

    }
}





