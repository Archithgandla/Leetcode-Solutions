class Pair{
    int val,idx;

    Pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        //Approach-1
        //Just create a ds called pair
        //and a array of pairs which consists of value and index
        //sort the pairs array based on value
        //Now use this array to replace elements with their ranks in arr
        //TC : O(NlogN)
        //SC : O(N)

        //Approach-2
        //Use Nested Loop
        //TC : O(N^2)
        //SC : O(N)

        Pair[] p = new Pair[arr.length];

        for(int i=0;i<arr.length;i++)
            p[i] = new Pair(arr[i],i);

        Arrays.sort(p,(a,b) -> a.val-b.val);
        int rank = 1;

        for(int i=0;i<p.length;i++){

            if(i>0 && p[i].val != p[i-1].val)
                rank+=1;

            arr[p[i].idx] = rank;
        }

        return arr;

    }
}





