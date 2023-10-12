/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    int mountainIndex(MountainArray mountainArr){

        int low = 0,high = mountainArr.length()-1;
        int mid = low+(high-low)/2;

        while(low<=high){
            
            int next = -1;
            if(mid+1<mountainArr.length())
                next = mountainArr.get(mid+1);

            if(mid+1<mountainArr.length() && mid-1>=0 && 
                mountainArr.get(mid)>next 
                && mountainArr.get(mid)>mountainArr.get(mid-1))
                return mid;
            
            else if(mid+1<mountainArr.length() && mountainArr.get(mid)<next)
                low = mid+1;
            else if(mid+1<mountainArr.length() && mountainArr.get(mid)>next)
                high = mid-1;
            mid = low+(high-low)/2;
        }
        return mid;

    }

    int BinarySearchI(MountainArray mountainArr,int target,int low,int high){

        int mid = low+(high-low)/2;


        while(low<=high){
            
            int midEle = mountainArr.get(mid);

            if(midEle == target)
                return mid;
            
            else if(midEle >target)
                high = mid-1;
            else
                low = mid+1;
            mid = low+(high-low)/2;           
        }

        return -1;

    }

    int BinarySearchD(MountainArray mountainArr,int target,int low,int high){

        int mid = low+(high-low)/2;


        while(low<=high){
            
            int midEle = mountainArr.get(mid);

            if(midEle == target)
                return mid;
            
            else if(midEle>target)
                low = mid+1;
            else
                high = mid-1;
            mid = low+(high-low)/2;           
        }

        return -1;

    }




    public int findInMountainArray(int target, MountainArray mountainArr) {

        //Here the task is simple to find the index of first occurence of our elemnt
        //It can be done using simple traversal
        //But in the worst case we have to traverse till the last element(element is present at
        //last position or not present at all)
        //Since the maximum size of array is 10^4, so we need to call .get() method
        //10^4 times but according to constraints we can call it only 100 times
        //So we need to reduce out search space which can be done using binary search
        //But we cannot directly apply binary search since the array is not completely sorted

        //Approach
        //First find the mountain element index using binary search(mountain elemnt problem is 
        //prerequisite for this problem)
        //the arrray is sorted from index 0 to mountainIndex and mountainIndex to last      element  (decreasing order)
        //Now just apply Binary search on these subarrays
        //If element is found in subarray 0 to mountainIndex return it
        //else check it in  mountainIndex to last element
        

        int mtnIndex = mountainIndex(mountainArr);
        System.out.println("mountain Index : "+mtnIndex);

        int firstHalf = BinarySearchI(mountainArr,target,0,mtnIndex);       
        //System.out.println("FirstHalf : "+firstHalf);

        if(firstHalf != -1)
            return firstHalf;
        
        int secondHalf = BinarySearchD(mountainArr,target,mtnIndex,
                            mountainArr.length()-1); 
        //System.out.println("secondHalf : "+secondHalf);

        return secondHalf;

    }
}




