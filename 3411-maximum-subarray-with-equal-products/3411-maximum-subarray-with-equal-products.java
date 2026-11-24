class Solution {

    public int lcm(int a,int b){

        int minm = Math.min(a,b),maxm = Math.max(a,b);

        while(true){
            if(maxm%a == 0 && maxm%b == 0)
                return maxm;
            maxm+=1;
        }

    }

    public int gcd(int a,int b){

        int minm = Math.min(a,b),maxm = Math.max(a,b);

        for(int i=minm;i>=1;i--){
            if(a%i == 0 && b%i == 0)
                return i;
        }

        return -1;
    }

    public int maxLength(int[] nums) {

        int maxm = 1;

        for(int i=0;i<nums.length;i++){            
            int prod = nums[i],lcm = nums[i],gcd = nums[i];
            
            for(int j=i+1;j<nums.length;j++){
                prod*=nums[j];

                lcm = lcm(lcm,nums[j]);
                gcd = gcd(gcd,nums[j]);

                if(prod == lcm*gcd)
                    maxm = Math.max(maxm,j-i+1);
            }
        }

        return maxm;

    }
}
