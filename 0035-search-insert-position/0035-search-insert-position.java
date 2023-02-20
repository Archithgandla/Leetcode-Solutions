class Solution {
    public int searchInsert(int[] arr, int target) {
        int pos = -1;

        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;

        while(low<=high){
            if(arr[mid] == target)
                return mid;
            else if(arr[mid]>target){
                pos = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            mid = low+(high-low)/2;
        }


        return pos == -1?arr.length:pos;

    }
}