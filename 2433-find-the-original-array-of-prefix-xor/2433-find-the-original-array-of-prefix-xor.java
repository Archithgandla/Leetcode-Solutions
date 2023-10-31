class Solution {
    public int[] findArray(int[] pref) {
        
        int[] arr = new int[pref.length];
        int temp = pref[0];
        arr[0] = pref[0];
        
        
        for(int i=1;i<pref.length;i++){
            arr[i] = pref[i]^temp;
            temp = temp^arr[i];
        }
        
        return arr;
    }
}