
class Pair{
    int num,convert;
    
    Pair(int num,int convert){
        this.num = num;
        this.convert = convert;
    }
}


class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        

        Pair[] arr = new Pair[nums.length];
        
        for(int i=0;i<nums.length;i++){
            
            int num = nums[i],mul_fact = 1,ans = 0;
            int temp = num;

            if(num == 0)
                ans = mapping[0];
            
            while(num>0){
                int digit = num%10;
                ans = ans+(mapping[digit]*mul_fact);
                mul_fact*=10;
                num/=10;
            }
            arr[i] = new Pair(temp,ans);
            //System.out.println(temp+" "+ans);
        }
        
        
        Arrays.sort(arr,(a,b) -> a.convert-b.convert);
        
        for(int i=0;i<nums.length;i++)
            nums[i] = arr[i].num;
        
        
        
        return nums;
    }
}









