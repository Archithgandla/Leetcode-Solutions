class Solution {
    public boolean isPathCrossing(String path) {
        
        
        int hor = 0,ver = 0;
        HashMap<String,Boolean> hm = new HashMap<>();
        hm.put('0'+"$"+'0',true);
        
        for(char c:path.toCharArray()){
            if(c == 'E')
                hor+=1;
            if(c == 'W')
                hor-=1;
            if(c == 'N')
                ver+=1;
            if(c == 'S')
                ver-=1;
            
            String str = (char)(hor+'0')+"$"+(char)(ver+'0');
            
            //System.out.println(str);
            
            if(hm.containsKey(str))
                return true;
            
            hm.put(str,true);
        }
        
        return false;
        
    }
}