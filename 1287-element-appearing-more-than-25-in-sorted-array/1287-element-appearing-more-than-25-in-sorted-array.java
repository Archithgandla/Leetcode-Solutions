class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int pre = -1,count = 0;
        
        for(int i:arr){
            if(i == pre)
                count+=1;
            else{
                count = 1;
                pre = i;
            }
            
            
            if(count>(arr.length/4))
                return pre;
        }
        
        return pre;
    }
}






