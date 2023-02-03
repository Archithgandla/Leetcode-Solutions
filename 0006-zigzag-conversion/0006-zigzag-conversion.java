class Solution {
    public String convert(String s, int numRows) {
        //Refer neetcode yt channel for constant space solution 
        if(numRows == 1)
            return s;
        char[][] arr = new char[numRows][s.length()];
        
        for(char[] a:arr)
            Arrays.fill(a,'-');

        int row=0,col=0;

        while(col<s.length()){
            while(row<numRows && col<s.length()){
                arr[row][col] = s.charAt(col);
                row+=1;col+=1;
            }
            row-=2;

            while(row>=0 && col<s.length()){
                arr[row][col] = s.charAt(col);
                row-=1;col+=1;
            }
            row+=2;
        }

        //Row wise traversal
        StringBuilder ans = new StringBuilder("");
        //int row = 0,col = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                if(arr[i][j] != '-')
                    ans.append(arr[i][j]);
        }
        return ans.toString();
    }
}