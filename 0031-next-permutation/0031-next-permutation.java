class Solution {
    public void nextPermutation(int[] arr) {
        int id = -1;
        
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                id = i;
                break;
            }
        }
        //System.out.println("id : "+id);
        
        //Number is in descending order
        //Next number will be in ascecfing order
        if(id == -1){
            for(int i=0;i<arr.length/2;i++){
                int temp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = temp;
            }
            return;
        }
        
        int temp = -1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[id]){
                temp = i;
                break;
            }
        }
        
        int t = arr[temp];
        arr[temp] = arr[id];
        arr[id] = t;
        
        
        //Reversing the array
        id+=1;
        int j = arr.length-1;        
        
        while(id<j){
            int a = arr[id];
            arr[id] = arr[j];
            arr[j] = a;
            
            id+=1;
            j-=1;
        }
        
    }
}