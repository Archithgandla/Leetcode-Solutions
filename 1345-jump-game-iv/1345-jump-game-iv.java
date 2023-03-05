//Reference : https://www.youtube.com/watch?v=tr1WHelOhJU


class Solution {



    public int minJumps(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        for(int i=arr.length-1;i>=0;i--){
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],new ArrayList<Integer>());
            ArrayList<Integer> Al = hm.get(arr[i]);
            Al.add(i);
            hm.put(arr[i],Al);
        }

        q.add(0);
        int steps = 0;
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;

        while(q.size()>0){
            int count = q.size();

            while(count>0){
                int index = q.poll();

                if(index == arr.length-1)
                    return steps;

                if(index+1<=arr.length && !visited[index+1]){
                    visited[index+1] = true;
                    q.add(index+1);
                }

                if(index-1>=0 && !visited[index-1]){
                    visited[index-1] = true;
                    q.add(index-1);
                }

                if(hm.containsKey(arr[index])){
                    
                    ArrayList<Integer> Al = hm.get(arr[index]);

                    for(int i=0;i<Al.size();i++){
                        if(!visited[Al.get(i)]){
                            visited[Al.get(i)] = true;
                            q.add(Al.get(i));
                        }
                    }

                    //Deleting elements once it is visited because to avoid extra iterations when arr[indx]
                    //again
                    Al.clear();
                }


                count-=1;
            }
            steps+=1;
        }

        return -1;
    }
}