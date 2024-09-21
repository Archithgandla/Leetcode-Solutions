class Solution {

    public void Util(int curr,int n,List<Integer> Al){
        if(curr>n)
            return;

        Al.add(curr);
        
        for(int i=0;i<=9;i++){
            if((curr*10+i)>n)
                return;
            Util((curr*10)+i,n,Al);
        }

        return;
    }



    public List<Integer> lexicalOrder(int n) {

        //Approach - 1
        //store all the elements from 1-n in a arraylist as a string format
        //sort the arraylist
        //time complexity : O(NLogn) since it involves sorting

        //Approach - 2 (The one i used)
        //Depth first search
        //Time complexity O(N)

        //Approach - 3
        //BFS
        //Time complexity O(N)


        List<Integer> Al = new ArrayList<>();
        for(int i=1;i<=9;i++){
            if(i>n)
                break;
            Util(i,n,Al);
        }
        return Al;
    }
}



