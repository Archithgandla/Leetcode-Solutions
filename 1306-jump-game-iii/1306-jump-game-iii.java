//Very similar to graph
//try to visualize it as graph
//If u are at a particular index,consider it as a vertex and it is connected
// to vertices they are index+arr[index] and index-arr[index]
//and arr[index] == 0 is the destination
//I solved using DFS
//It can be solved similarly using BFS

class Solution {
    boolean Util(int index,int[] arr,boolean[] visited){
        if(arr[index] == 0)
            return true;
        
        int k = index;

        if(arr[index]+k<arr.length && !visited[arr[index]+k]){
            visited[arr[index]+k] = true;

            if(Util(arr[index]+k,arr,visited))
                return true;

            visited[arr[index]+k] = false;
        }

        if(k-arr[index]>=0 && !visited[k-arr[index]]){
            visited[k-arr[index]] = true;

            if(Util(k-arr[index],arr,visited))
                return true;

            visited[k-arr[index]] = false;
        }
        return false;
    }


    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        return Util(start,arr,visited);
    }
}