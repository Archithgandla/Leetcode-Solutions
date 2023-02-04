//can be optimized by using only hashmap instead of both hashmap and array

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length()<s1.length())
            return false;
        //Frequency array
        int[] arr = new int[26];
        HashMap<Character,Integer> hm = new HashMap<>();

        for(char c:s1.toCharArray()){
            hm.put(c,1);
            arr[c-'a']-=1;
        }

        //Creating a window of length equal to length of string s1
        int k=s1.length();
        int j=0,count = k,i=0;

        while(j<k){
            char c = s2.charAt(j);
            if(hm.containsKey(c) && arr[c-'a']<0)
                count-=1;
            arr[c-'a']+=1;
            j+=1;
        }

        if(count == 0)
            return true;


        //Traversing the entire string
        while(j<s2.length()){
            //Moving the window

            char c1 = s2.charAt(i);
            char c2 = s2.charAt(j);
            if(hm.containsKey(c1) && arr[c1-'a'] <= 0){
                count+=1;
            }
            arr[c1-'a']-=1;
            i+=1;

            if(hm.containsKey(c2) && arr[c2-'a'] <0)
                count-=1;
            arr[c2-'a']+=1;

            if(count == 0)
                return true;
            j+=1;
        }
        return false;
    }
}