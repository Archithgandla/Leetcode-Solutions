class Solution {


    int[] left_smallest(int[] arr){
        
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){

            while(st.size()>0 && arr[i]<arr[st.peek()])
                st.pop();
            
            if(st.size() == 0){
                ans[i] = i+1;
                st.push(i);
                continue;
            }

            ans[i] = i-st.peek();
            st.push(i);
        }

        return ans;
    }

    int[] left_smallest_equal(int[] arr){
        
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){

            while(st.size()>0 && arr[i]<=arr[st.peek()])
                st.pop();
            
            if(st.size() == 0){
                ans[i] = i+1;
                st.push(i);
                continue;
            }

            ans[i] = i-st.peek();
            st.push(i);
        }

        return ans;
    }



    int[] right_smallest(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(st.size()>0 && arr[i]<arr[st.peek()])
                st.pop();
            
            if(st.size() == 0){
                ans[i] = arr.length-i;
                st.push(i);
                continue;
            }

            ans[i] = st.peek()-i;
            st.push(i);
        }

        return ans;
    }




    public int sumSubarrayMins(int[] arr) {
        
        //Approach-1
        //Use a nested loop and calculate all the subarray minimums
        //Time complexity : O(N^2)
        //Space : O(1)


        //Approach-2
        //For a array of size n there are n(n+1)/2 subarrays
        //For each element we need to calculate the number of subarrays in which it is 
        //minimum
        //To calculate this calculate the next and left smallest element for each element
        //multiple left and right indices to calcuate the number of subarrays

        long ans = 0;
        int[] left = left_smallest(arr);
        int[] left_equal = left_smallest_equal(arr);
        int[] right = right_smallest(arr);
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            
            long add = -1;

            if(hm.containsKey(arr[i]))
                add = (left[i]*right[i]*(long)arr[i])%(int)(1e9+7);
            else
                add = (left_equal[i]*right[i]*(long)arr[i])%(int)(1e9+7);
            
            ans+=add;
            ans%=((int)(1e9+7));
            //System.out.println(left[i]+" "+right[i]);
        }


        return (int)ans;

    }
}

