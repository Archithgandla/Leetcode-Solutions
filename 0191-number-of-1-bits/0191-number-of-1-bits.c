int hammingWeight(uint32_t n) {
        int count = 0;
        
        while(n>0){
            count+=((n&(int)1) == 1?1:0);
            n = n>>1;
        }

        return count;

        //OPTIMIZED APPROACH
        //KENNINGHAN'S ALGORITHM
}