class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        

        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0;i<cpdomains.length;i++){
            
            String str = cpdomains[i],domain = "";
            int num = 0;

            for(int j=0;j<str.length();j++){

                if(str.charAt(j) == ' '){
                    domain = str.substring(j+1);
                    break;
                }
                num = num*10+(int)(str.charAt(j)-'0');
            }

            //System.out.println(num);
            hm.put(domain,hm.getOrDefault(domain,0)+num);



            for(int j=0;j<domain.length();j++){
                if(domain.charAt(j) == '.')
                    hm.put(domain.substring(j+1),hm.getOrDefault(domain.substring(j+1),0)+num);
            }
        }
        
        List<String> ans = new ArrayList<>();
        //System.out.println(hm);

        for(String key:hm.keySet())
            ans.add(hm.get(key)+" "+(key));

        return ans;

    }
}

