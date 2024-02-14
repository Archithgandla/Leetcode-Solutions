class Solution {

    public void rotate(int[] nums,int start,int end){

        int temp = nums[end];

        while(end>start){
            nums[end] = nums[end-1];
            end-=1;
        }

        nums[start] = temp;
        return;
    }



    public int[] rearrangeArray(int[] nums) {
        

        //Approach-1
        //Using Extra Space
        //Store postive and negative elements in seperate arrays and fill them
        //one by one alternatvely in nums array
        //Time complexity : O(N)
        //Space Complexity : O(N)
        
        //Approach-2
        //Without using extra space

        int idx = 0,nex_pos = 0,nex_neg = 0;

        while(idx<nums.length){

            if((idx%2 == 0 && nums[idx]>0) || (idx%2 != 0 && nums[idx]<0)){
                idx+=1;
                continue;
            }

            if(idx%2 == 0){
                
                int temp = Math.max(nex_pos,idx);

                while(temp<nums.length && nums[temp]<0)
                    temp+=1;
                
                
                //To make sure that relative order of same sign elements is not changed
                rotate(nums,idx,temp);
                nex_pos = temp;
                
                idx+=2;
                continue;
            }

            int temp = Math.max(nex_neg,idx);

            while(temp<nums.length && nums[temp]>0)
                temp+=1;
            
            nex_neg = temp;
            rotate(nums,idx,temp);
            idx+=2;
        }

        return nums;

    }
}



