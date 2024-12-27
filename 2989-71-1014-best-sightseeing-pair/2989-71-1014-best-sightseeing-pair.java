class Pair{

    int val,idx;

    Pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        //Approach-1
        //Use a nested loop
        //Time complexity : O(N^2)

        //Approach-2
        //

        Stack<Pair> st = new Stack<>();
        st.add(new Pair(values[0],0));
        int maxm = Integer.MIN_VALUE;


        for(int i=1;i<values.length;i++){

            maxm = Math.max(maxm,values[i]+st.peek().val+st.peek().idx-i);

            while(st.size()>0 && values[i]>st.peek().val-(i-st.peek().idx))
                st.pop();

            if(st.size() == 0)
                st.push(new Pair(values[i],i));
        }


        return maxm;

    }
}





