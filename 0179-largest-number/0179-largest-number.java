class Solution {

    public String largestNumber(int[] nums) {

        StringBuilder ans = new StringBuilder("");
        ArrayList<String> Al = new ArrayList<>();

        for(int num:nums)
            Al.add(String.valueOf(num));

        Collections.sort(Al,(a,b) -> (b+a).compareTo(a+b));
        System.out.println(Al);


        for(String str:Al)
            ans.append(str);

        int i=0;
        
        while(i<ans.length() && ans.charAt(i) == '0')
            i+=1;
        
        return i!=ans.length() ? ans.toString().substring(i) :"0";

        // System.out.println(customSort("111311","1113"));

        // return "";

    }
}


