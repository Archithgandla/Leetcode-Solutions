class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0;
                   
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 1)
                continue;
            else if(i==0 && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                count+=1;
                flowerbed[i] = 1;
            }
            else if(i == flowerbed.length-1 && flowerbed[i-1] == 0){
                count+=1;
                flowerbed[i] = 1; 
            }
            else if(i-1>=0 && i+1<flowerbed.length && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                count+=1;
                flowerbed[i] = 1; 
            }            
        }

        return count>=n?true:false;
    }
}