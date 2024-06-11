class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        //Approach-1        
        //using hm count the frequency of each element in arr1 that are present n arr2
        //If a total of x elements are captured in hm, that means remaiining elements
        //are not present on arr2, so push these elements to the end of arr2
        //and sort them
        //now iterate through arr2 and arrange elements in arr1 until the freqeucy
        //of each element extinguishes
        //TC : O(NlogN) where K is number of elements of arr1 not present in arr2
        //SC : O(1)


        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;

        for(int i:arr2)
            hm.put(i,0);

        for(int j=0;j<arr1.length;j++){

            int i = arr1[j];

            if(!hm.containsKey(i)){
                count+=1;
                continue;
            }
            hm.put(i,hm.get(i)+1);
            arr1[j] = -1;
            
        }

        int idx = arr1.length-count-2;
        //System.out.println(Arrays.toString(arr1));

        for(int j=0;j<arr1.length;j++){
            int i = arr1[j];

            if(i == -1)
                continue;
            arr1[j] = -1;    
            arr1[idx++] = i;

            //System.out.println(idx);

        }

        Arrays.sort(arr1);
        idx = 0;
        //System.out.println(Arrays.toString(arr1));

        for(int i:arr2){

            int freq = hm.get(i);

            while(freq>0){
                arr1[idx] = i;
                idx+=1;
                freq-=1;
            }
        }



        return arr1;
        
        
    }
}



