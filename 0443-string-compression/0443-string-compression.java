class Solution {
    public int compress(char[] chars) {

        if(chars.length == 1)
            return 1;

        int count = 0,temp_count = 1,index = 0;
        char curr = chars[0];
        
        for(int i=1;i<chars.length;i++){
            if(chars[i] != curr){              
                chars[index] = curr;
                curr = chars[i]; 
                index+=1;
            
                if(temp_count<=1){
                    continue;
                }

                String a = String.valueOf(temp_count);                
                for(char c:a.toCharArray()){                    
                    chars[index] = c;
                    index+=1;
                }               
                temp_count=1;
            }
            else
                temp_count+=1;
        }
        

        chars[index] = curr;
        index+=1;
        
        if(temp_count<=1)
            return index;

        String a = String.valueOf(temp_count);             
        for(char c:a.toCharArray()){
            chars[index] = c;
            index+=1;
        }
        //System.out.println("hey");       
        return index;
    }
}