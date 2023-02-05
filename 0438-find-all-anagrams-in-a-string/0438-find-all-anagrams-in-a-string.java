class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length())
            return new ArrayList<>();

        int[] freq = new int[26];
        HashMap<Character,Integer> hm = new HashMap<>();

        for(char c:p.toCharArray()){
            freq[c-'a']-=1;
            hm.put(c,1);
        }
        //Creating a window
        int k = p.length();
        int i=0,j=0,count = k;
        List<Integer> ans = new ArrayList<>();

        while(j<k){
            if(hm.containsKey(s.charAt(j)) && freq[s.charAt(j)-'a']<0)
                count-=1;
            freq[s.charAt(j)-'a']+=1;
            j+=1;
        }
        System.out.println(count);
        if(count == 0)
            ans.add(i);

        //Moving the window
        while(j<s.length()){
            //System.out.println("hi");
            if(hm.containsKey(s.charAt(i)) && freq[s.charAt(i)-'a']<=0)
                count+=1;
            freq[s.charAt(i)-'a']-=1;
            i+=1;

            if(hm.containsKey(s.charAt(j)) && freq[s.charAt(j)-'a']<0)
                count-=1;
            freq[s.charAt(j)-'a']+=1;
            j+=1;

            if(count == 0)
                ans.add(i);
        }
        return ans;
    }
}













