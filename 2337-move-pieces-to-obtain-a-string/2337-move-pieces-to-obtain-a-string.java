class Solution {
    public boolean canChange(String start, String target) {
        
        if(start.length() != target.length())
            return false;

        
        int l = 0,r = 0;

        for(char c:start.toCharArray()){
            if(c == 'L')
                l+=1;
            else if(c == 'R')
                r+=1;
        }

        for(char c:target.toCharArray()){
            if(c == 'L')
                l-=1;
            else if(c == 'R')
                r-=1;
        }

        if(l !=0  || r != 0)
            return false;

        int count = 0;
        char[] arr = start.toCharArray();


        //checking if L can be set correctly
        for(int i=start.length()-1;i>=0;i--){
            if(start.charAt(i) == 'L' && target.charAt(i) == 'L')
                continue;
            else if(start.charAt(i) == 'R' && target.charAt(i) == 'L')
                return false;
            else if(start.charAt(i) == 'R')
                count = 0;
            else if(start.charAt(i) == 'L'){
                arr[i] = '_';
                count+=1;
            }
            else if(start.charAt(i) == '_' && target.charAt(i) == 'L'){
                if(count<=0)
                    return false;
                count-=1;
                arr[i] = 'L';
            }

        }

        start = new String(arr);



        count = 0;
        //checking if R can be set correctly
        for(int i=0;i<start.length();i++){
            if(start.charAt(i) == 'R' && target.charAt(i) == 'R')
                continue;
            else if(start.charAt(i) == 'L' && target.charAt(i) == 'R')
                return false;
            else if(start.charAt(i) == 'L')
                count = 0;
            else if(start.charAt(i) == 'R')
                count+=1;
            else if(start.charAt(i) == '_' && target.charAt(i) == 'R'){
                if(count<=0)
                    return false;
                count-=1;
            }
        }

        return true;
    }
}