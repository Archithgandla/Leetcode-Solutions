class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        HashMap<String,Boolean> hm = new HashMap<>();
        int ans = 0;

        for(int[] temp:dig){
            hm.put(String.valueOf(temp[0])+"$"+String.valueOf(temp[1]),true);
        }

        //System.out.println(hm);

        for(int[] artifact:artifacts){

            int count = 0;
            for(int i=artifact[0];i<=artifact[2];i++){
                for(int j=artifact[1];j<=artifact[3];j++){

                    if(!hm.containsKey(String.valueOf(i)+"$"+String.valueOf(j))){
                        i = artifact[2]+1;
                        j = artifact[3]+1;
                        break;
                    }
                    count+=1;
                }
            }

            int expectedCount = (artifact[2]-artifact[0]+1)*(artifact[3]-artifact[1]+1);
            //System.out.println(expectedCount+" "+count);
            ans+=(expectedCount == count?1:0);
        }

        return ans;

    }
}







