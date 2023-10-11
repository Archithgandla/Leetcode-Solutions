class Solution {


    int upper_limit(int[] arr,int x){

        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;
        int ans = -1;

        while(low<=high){
            //System.out.println(low+" "+high);
            if(arr[mid]<=x)
                low = mid+1;
            else if(arr[mid]>x){
                ans = mid;
                high = mid-1;
            }
            mid = low+(high-low)/2;
        }
        return ans;
    }

    int lower_limit(int[] arr,int x){
        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;
        int ans = -1;

        while(low<=high){
            if(arr[mid]<x){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid]>=x){
                high = mid-1;
            }
            mid = low+(high-low)/2;
        }
        return ans;
    }



    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        //Just use a array with size maxm(ends)-minm(starts)
        //each index represents a particular moment in time like 1,2,3,.....
        //For each flower increment all the indices from start to end-1 by 1
        //Now if you want to consider flowers at a particular moment
        //it is the value at that particular index in the array

        //Instead of incrementing the array for the entire range i.e start to end-1
        //for all the flowers
        //use range sum concept
        //arr[start]+=1 arr[end+1]-=1
        //now calculate prefix sum
        //Now if you want to consider flowers at a particular moment
        //it is the value at that particular index in the array


        //Now instead of using an array
        //For each entry in people array just traverse the flowers array and
        //calculate the number of flowers active at that time


        //Binary search
        int[] starts = new int[flowers.length];
        int[] ends = new int[flowers.length];


        for(int i=0;i<flowers.length;i++){
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int[] ans = new int[people.length];

        for(int i=0;i<people.length;i++){

            int avail = flowers.length;
            int ll = lower_limit(ends,people[i]);

            if(ll != -1)
                avail-=(ll+1);

            int ul = upper_limit(starts,people[i]);

            if(ul != -1)
                avail-=(flowers.length-ul);
            
            //System.out.println("final : "+ll+" "+ul);

            ans[i] = avail>0?avail:0;
        }
        return ans;

    }
}









