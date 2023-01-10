class Solution {
    
    int squares(int N){
        int sum = 0;
        
        while(N>0){
            sum+=Math.pow(N%10,2);
            N = N/10;
        }
        return sum;
    }
    
    //METHOD-1
    //Time : O(N)
    //Space : O(N)
//     public boolean isHappy(int n) {
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         while(true){
//             int sum = squares(n);
            
//             if(sum == 1)
//                 return true;
//             if(hm.containsKey(sum))
//                 return false;
            
//             hm.put(sum,1);
//             n = sum;
            
//         }
//         //return false;
//     }
    
    
    //METHOD-2
    //TIME : O(N)
    //SPACE : O(1)
    
    public boolean isHappy(int n){
        int slow = n,fast = n;
        
        do{
            slow = squares(slow);
            fast = squares(squares(fast));
            //System.out.println(slow+" "+fast);
        }while(slow != fast);
        
        return fast == 1;
        
    }
    
}