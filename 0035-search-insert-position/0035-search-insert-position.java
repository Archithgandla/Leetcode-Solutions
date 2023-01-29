class Solution {
    //calculating the lower bound
    //Upper bound can also be used
    public int searchInsert(int[] arr, int target) {
        
        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;
        int ans = -1;
        
        while(low<=high){
            if(arr[mid] == target)
                return mid;
            else if(arr[mid]>target)
                high = mid-1;
            else if(arr[mid]<target){
                ans = mid;
                low = mid+1;
            }
            mid = low+(high-low)/2; 
        }
        
        return ans == -1?0:ans+1;
        
    }
    
}