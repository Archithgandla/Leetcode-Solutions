class Solution {

    boolean Util(HashMap<Integer,ArrayList<Integer>> hm,int[] ans){

        for(int i=1;i<ans.length-1;i++){
            
            if(!hm.containsKey(ans[i-1]))
                return false;

            int curr = -1;
            
            if(i == 1)
                curr = hm.get(ans[i-1]).get(0);
            else if(ans[i-2] != hm.get(ans[i-1]).get(0))
                curr = hm.get(ans[i-1]).get(0);
            else
                curr = hm.get(ans[i-1]).get(1);
            
            ans[i] = curr;

            //ans[i] = hm.get(ans[i-1]);
        }
        return true;
    }


    public int[] restoreArray(int[][] adjacentPairs) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> neighbours = new HashMap<>();
        int[] ans = new int[adjacentPairs.length+1];

        for(int[] arr:adjacentPairs){
            hm.put(arr[0],hm.getOrDefault(arr[0],0)+1);
            hm.put(arr[1],hm.getOrDefault(arr[1],0)+1);

            if(!neighbours.containsKey(arr[0]))
                neighbours.put(arr[0],new ArrayList<>());
            if(!neighbours.containsKey(arr[1]))
                neighbours.put(arr[1],new ArrayList<>());

            ArrayList<Integer> Al = neighbours.get(arr[0]);
            Al.add(arr[1]);
            neighbours.put(arr[0],Al);

            Al = neighbours.get(arr[1]);
            Al.add(arr[0]);
            neighbours.put(arr[1],Al);
        }

        System.out.println(neighbours);

        boolean flag = false;
        for(int k:hm.keySet()){
            
            if(hm.get(k)>1)
                continue;

            if(!flag){
                ans[0] = k;
                flag = !flag;
                continue;
            }

            ans[ans.length-1] = k;
            break;
        }

        //System.out.println(Arrays.toString(ans));
        Util(neighbours,ans);
        
        return ans;

        // int[] temp = new int[ans.length];
        // temp[0] = ans[ans.length-1];
        // temp[ans.length-1] = ans[0];

        //System.out.println(Arrays.toString(temp));


        // Util(neighbours,temp);
        // return temp;

        //return ans;

    }
}




