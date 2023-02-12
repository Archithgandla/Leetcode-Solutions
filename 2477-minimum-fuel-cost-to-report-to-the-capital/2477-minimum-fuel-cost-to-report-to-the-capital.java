//Reference : https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/solutions/3173765/clean-codes-full-explanation-dfs-c-java-python3/
//and neetcode



//There are no cycles so there is no need of visited array
//if(node != parent) this condition is enough


//Consider it to be a tree since there are no children
//here we are just counting the number of child nodes for each node
//Since all child nodes pass through parent to the destionation i.e 0
//At each parent node we calcuate no of cars needed to transer all its child and itself
//to its corresponding parent node
//Each car requires 1 unit to moves to its parent

class Solution {

    long Ceil(int a,int b){
        if(a%b == 0)
            return a/b;
        return (a/b)+1;
    }



    long ans;
    public long DFS(ArrayList<ArrayList<Integer>> adj,int node,int par,int seats){

        int people = 1;

        for(int i:adj.get(node)){
            if(i!=par){
                people+=(DFS(adj,i,node,seats));
            }
        }

        //Number of cars requires = ceil(people/cars)
        //if we are at node 0 then we are already at destination so no cost is associated
        if(node != 0)
            ans+=Ceil(people,seats);
        return people;

    }

    public long minimumFuelCost(int[][] roads, int seats) {
        //creating a adjacent list
        ArrayList<ArrayList<Integer>> Al = new ArrayList<>();
        ans = 0;

        //To connect n nodes we need n+1 edges
        for(int i=0;i<roads.length+1;i++)
            Al.add(new ArrayList<>());

        for(int[] arr:roads){
            Al.get(arr[0]).add(arr[1]);
            Al.get(arr[1]).add(arr[0]);
        }

        DFS(Al,0,-1,seats);
        return ans;
    }
}



