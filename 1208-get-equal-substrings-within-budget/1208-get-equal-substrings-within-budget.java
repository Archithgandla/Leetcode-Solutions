class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int i=0,j=0,cost = 0;
        int maxm = Integer.MIN_VALUE;

        while(j<s.length()){
            
            if(cost<=maxCost){
                maxm = Math.max(j-i,maxm);
                cost+=(Math.abs(s.charAt(j)-t.charAt(j)));
                j+=1;
            }

            else{
                cost-=(Math.abs(s.charAt(i)-t.charAt(i)));
                i+=1;
            }            

            //System.out.println(i+" "+j+" "+cost+" "+maxm);
        }

        if(cost<=maxCost)
            maxm = Math.max(j-i,maxm);


        return maxm;

    }
}



