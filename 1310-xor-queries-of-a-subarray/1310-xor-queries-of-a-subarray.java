class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] ans = new int[queries.length];
        int xorTotal = arr[0];
        left[0] = arr[0];
        right[arr.length-1] = arr[arr.length-1]; 

        for(int i=1;i<arr.length;i++){
            left[i] = left[i-1]^arr[i];
            xorTotal^=arr[i];
        }

        for(int i=arr.length-2;i>=0;i--)
            right[i] = right[i+1]^arr[i]; 
        

        for(int i=0;i<queries.length;i++)
            ans[i] = xorTotal^left[queries[i][0]]^right[queries[i][1]]^arr[queries[i][0]]^arr[queries[i][1]];
        

        return ans;
    }
}





