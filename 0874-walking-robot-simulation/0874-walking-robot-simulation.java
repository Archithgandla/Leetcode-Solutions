



class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashMap<ArrayList<Integer>,Integer> hm = new HashMap<>();

        for(int[] obstacle:obstacles){
            ArrayList<Integer> Al = new ArrayList<>();
            Al.add(obstacle[0]);
            Al.add(obstacle[1]);
            hm.put(Al,1);
        }

        int[][] directions = new int[4][2];
        int idx = 0,x = 0,y = 0,maxm = Integer.MIN_VALUE;
        directions[0] = new int[]{0,1};
        directions[1] = new int[]{1,0};
        directions[2] = new int[]{0,-1};
        directions[3] = new int[]{-1,0};


        for(int command:commands){
            
            if(command == -1){
                idx = (idx+1)%4;
                continue;
            }
            else if(command == -2){
                idx = (idx+3)%4;
                continue;
            }

            while(command>0){
                x+=directions[idx][0];
                y+=directions[idx][1];

                ArrayList<Integer> Al = new ArrayList<>();
                Al.add(x);
                Al.add(y);

                if(hm.containsKey(Al)){
                    x-=directions[idx][0];
                    y-=directions[idx][1];
                    break;
                }

                maxm = Math.max(maxm,(x*x)+(y*y));
                command-=1;
            }

        }

        return maxm == Integer.MIN_VALUE?0:maxm;

    }
}


