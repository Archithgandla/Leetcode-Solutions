class Solution {
    public int[] singleNumber(int[] nums) {

        //https://www.youtube.com/watch?v=UA5JnV1J2sI

        int temp = 0,xor1 = 0,xor2 = 0;

        for(int i:nums)
            temp^=i;

        int rsb = (temp&(-temp));

        System.out.println(rsb);

        for(int i:nums){
            

            if((i&rsb) == 0){
                xor1 = xor1^i;
                System.out.println(i);
            }
            else
                xor2 = xor2^i;
        }

        return new int[]{xor1,xor2};

    }
}






