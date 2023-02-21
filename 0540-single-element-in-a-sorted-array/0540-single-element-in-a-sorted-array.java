class Solution {
    public int singleNonDuplicate(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        
        
        //boundary checks
        if(high == 0)
            return arr[0];
        else if(arr[low] != arr[low+1])
            return arr[0];
        else if(arr[high] != arr[high-1])
            return arr[high];
        
        int mid = low + (high-low)/2;
        while(low<=high){
            
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
                return arr[mid];
            
            //if mid is even the mid^1 is mid+1 and if arr[mid] == arr[mid+1] then order is maintained
            //if mid is odd then mid^1 is mid-1 and if arr[mid] == arr[mid-1] then order is maintained
            //and still havent reached the individual element
            //so low = mid+1
            else if(arr[mid] == arr[mid^1])
                low = mid+1;
            //We have crossed the individual element 
            //so move mid back
            else
                high = mid-1;
            
            mid = low + (high-low)/2;
        }
        return arr[low];
        
    }
}