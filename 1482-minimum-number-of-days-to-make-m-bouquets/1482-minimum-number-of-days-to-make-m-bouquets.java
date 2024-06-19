class Solution {
    

    public int Util(int[] bloomDay,int target,int k){

        int i=0,j=0,count=0;

        while(j<bloomDay.length){

            //System.out.println("count : "+j+" "+count);

            if(bloomDay[j]>target){
                count+=((j-i)/k);
                j+=1;
                i = j;
                continue;
            }
            j+=1;
        }
        count+=((j-i)/k);


        return count;
    }





    public int minDays(int[] bloomDay, int m, int k) {

        int low = 0,high = -1;

        for(int i:bloomDay)
            high = Math.max(i,high);
        

        int mid = low+(high-low)/2;
        int ans = -1;

        while(low<=high){
            
            int temp = Util(bloomDay,mid,k);
            //System.out.println(mid+" "+temp);

            if(temp>=m){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
            
            mid = low+(high-low)/2;
        }

        return ans;

    }
}





