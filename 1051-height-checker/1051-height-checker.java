class Solution {
    public int heightChecker(int[] heights) {
        
        //Approach-1
        //Make a copy of the array sort it and calcuate wheter each element
        //is at its correct position

        //Approach-2
        //For each elemet calculate the number of smaller elements
        //to calcuate its right index in sorted order

        //Approach-3
        //count sort 

        int[] arr = new int[101];

        for(int i:heights)
            arr[i]+=1;

        int count = 0;

        for(int i=0;i<heights.length;i++){

            int num = heights[i],temp = 0;

            for(int j=num-1;j>=1;j--)
                temp+=arr[j];

            //The correct index should be between count and count+arr[j]-1

            if(i>=temp && i<temp+arr[num])
                continue;

            //System.out.println(num+" "+i+" "+arr[i]);
            count+=1;

        }


        return count;

    }
}




