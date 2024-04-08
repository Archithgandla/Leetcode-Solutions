class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        
        int i=0,j=0,count = 0;
        
        while(j<sandwiches.length){
            
            
            //System.out.println(i+" "+students[i]+" "+j+" "+sandwiches[j]);
            
            if(students[i] == -1){
                i = (i+1)%students.length;
                count+=1;
                
                if(count == students.length)
                    break;  
                
                continue;
            }
            
            if(students[i] == sandwiches[j]){
                students[i] = -1;
                //sandwiches[j] = -1;
                i = (i+1)%students.length;
                j+=1;
                count = 0;
                continue;
            }           
            i = (i+1)%students.length;
            count+=1;
            
            if(count == students.length)
                break;                
        
        }
        
        
        int ans = students.length;
        
        for(int temp:students)
            ans-=(temp == -1?1:0);
        
        return ans;

    }
}









