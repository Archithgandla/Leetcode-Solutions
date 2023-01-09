//Reference : https://www.youtube.com/watch?v=LzZFUTWE55c


//Brute force : Try all possible cases below maximum k value
//Optimized : Apply binary search on 1 to Kmax
class Solution {

    int ceil(int num,int den){
        if(num%den == 0)
            return num/den;
        return (num/den)+1;
    }



    public int minEatingSpeed(int[] piles, int h) {
        
        int maxi = Integer.MIN_VALUE;
        for(int i:piles)
            maxi = Math.max(i,maxi);

        //Binary search
        int low = 1,high = maxi;
        int mid = low + (high-low)/2;
        
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int count = 0;
            for(int i:piles)
                count+=ceil(i,mid);

            //System.out.println(mid+" "+count);
            //Count>0 condition is added to make that when int overflows and becomes
            //negative that count is not considered however that value is so huge
            //and it cannot become answer
            if(count<=h && count>0){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }

            mid = low + (high-low)/2;  

        }

        return ans;
    }
}