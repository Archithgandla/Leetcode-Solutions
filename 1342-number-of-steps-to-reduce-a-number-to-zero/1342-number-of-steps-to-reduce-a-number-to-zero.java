class Solution {

    public int numberOfSteps(int num) {
        
//         if(num <= 0)
//             return 0;

//         int count = 0;
//         if(num%2 == 0)
//             count+=(1+numberOfSteps(num/2));

//         else
//             count+=(1+numberOfSteps(num-1));
        
        int count = 0;
        
        while(num != 0){
            if(num%2 == 0)
                num/=2;
            else
                num-=1;
            count+=1;
        }
        
        return count;
    }
}