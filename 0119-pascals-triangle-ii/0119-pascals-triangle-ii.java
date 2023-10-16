class Solution {
    public List<Integer> getRow(int rowIndex) {

        if(rowIndex == 0){
            ArrayList<Integer> Al = new ArrayList<>();
            Al.add(1);
            return Al;
        }

        
        int[] prev = new int[rowIndex+1];
        int[] curr = new int[rowIndex+1];
        prev[0] = 1;

        for(int i=1;i<=rowIndex;i++){
            // System.out.println(Arrays.toString(prev));
            // System.out.println(Arrays.toString(curr));

            for(int j=0;j<=i;j++){
                
                if(j == 0 || j == i)
                    curr[j] = 1;
                else
                    curr[j] = prev[j]+prev[j-1];

                System.out.println("itera : "+Arrays.toString(prev));
            }
            // System.out.println(Arrays.toString(prev));
            // System.out.println(Arrays.toString(curr));
            System.out.println(" ");
            prev = new int[rowIndex+1];

            for(int k=0;k<rowIndex;k++)
                prev[k] = curr[k];

        }
        
        ArrayList<Integer> Al = new ArrayList<>();

        for(int i:curr)
            Al.add(i);


        return Al;

    }
}






