class Solution {
    public int bestClosingTime(String customers) {

        int[] postfix = new int[customers.length()];
        int count = 0,minm = Integer.MAX_VALUE,loss = 0,ans = -1;

        for(int i = customers.length()-1;i>=0;i--){
            
            if(customers.charAt(i) == 'Y')
                count+=1;
            postfix[i] = count;
        }

        count = 0;

        for(int i=0;i<customers.length();i++){
            
            if(loss+postfix[i]<minm){
                minm = loss+postfix[i];
                ans = i;
            }

            if(customers.charAt(i) == 'N')
                loss+=1;

        }



        return loss<minm?customers.length():ans;

    }
}


