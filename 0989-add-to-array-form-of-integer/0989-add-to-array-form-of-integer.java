class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> Al = new ArrayList<>();
        
        for(int i:num)
            Al.add(i);
        
        Collections.reverse(Al);
        
        int carry = 0,i=0;
        
        
        
        while(k>0 && i<Al.size()){
            int data = (k%10)+Al.get(i)+carry;
            int digit = data%10;
            Al.set(i,digit);
            carry = data/10;
            k/=10;
            i+=1;
        }
        
        while(carry>0 || k>0){
            int data = k%10+carry;
            
            if(i<Al.size()){
                data+=Al.get(i);
                Al.set(i,data%10);
            }
            else
                Al.add(data%10);
            carry = data/10;
            k=k/10;
            i+=1;
        }
        
            
        Collections.reverse(Al);
        return Al;
    }
}