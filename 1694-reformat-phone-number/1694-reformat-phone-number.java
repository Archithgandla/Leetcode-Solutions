class Solution {
    public String reformatNumber(String number) {
        
        int count = 0;

        for(char c:number.toCharArray()){
            if(c == ' ' || c == '-')
                continue;
            count+=1;
        }

        int rem = -1;

        if(count%3 == 0)
            rem = 0;
        else if(count%3 == 1)
            rem = 4;
        else 
            rem = 2;

        String ans = "",temp = "";
        int i = 0;

        for(i=0;i<number.length() && count>rem;i++){

            char c = number.charAt(i);;

            if(c == ' ' || c == '-')
                continue;
            
            temp = temp+c;

            if(temp.length()<3)
                continue;

            ans = ans+"-"+temp;
            temp = "";
            count-=3;

            if(count<=rem)
                break;
        }


        if(rem == 0)
            return ans.substring(1);
        
        //System.out.println(ans);
        temp = "";


        if(i != 0)
            i+=1;

        while(count>0 && i<number.length()){

            //System.out.println(i);

            char c = number.charAt(i);

            if(c == ' ' || c == '-'){
                i+=1;
                continue;
            }
            temp = temp+c;

            if(temp.length()<2){
                i+=1;
                continue;
            }

            ans = ans+"-"+temp;
            temp = "";
            count-=2;
            i+=1;
        }

        return ans.substring(1);

    }
}