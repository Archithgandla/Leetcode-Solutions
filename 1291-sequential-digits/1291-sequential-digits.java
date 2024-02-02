class Solution {
    
    
    public void Util(int low,int high,int num,int digit,List<Integer> li){

        //System.out.println(num);

        if(num>high)
            return;

        if(num>=low && num<=high)
            li.add(num);
        
        if(digit>9)
            return;

        Util(low,high,num*10+digit,digit+1,li);

        return;

    }
    
    
    public List<Integer> sequentialDigits(int low, int high) {
        
        //travel through all the numbers between low and high
        //and for each number check if it has sequential digits
        //Time complexity : O(N*(Number of digits in high))
        //This gives TLE

        int temp = low,digit_count = 0;

        while(temp/10>0){
            temp/=10;
            digit_count+=1;
        }

        List<Integer> ans = new ArrayList<>();


        for(int i=1;i<=9;i++)
            Util(low,high,0,i,ans);

        Collections.sort(ans);

        return ans;
        
    }
}



