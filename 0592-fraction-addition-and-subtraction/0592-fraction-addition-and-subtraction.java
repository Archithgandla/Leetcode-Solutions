class Solution {
    
    public int GCD(int a,int b){

        int minm = Math.min(a,b);
    
        for(int i=minm;i>=1;i--){

            if(a%i != 0 || b%i != 0)
                continue;
            return i;
        }
        return 1;
    }

    int[] extractNumber(String str,Integer index){

        int[] ans = new int[3];
        int mul = str.charAt(index) == '+'?1:-1;
        index+=1;

        while(str.charAt(index)  != '/'){
            int digit = (int)(str.charAt(index)-'0');
            ans[0] = ans[0]*10+digit;
            index+=1;
        }

        index+=1;

        while(index<str.length() && str.charAt(index)  != '+' && str.charAt(index)  != '-'){
            int digit = (int)(str.charAt(index)-'0');
            ans[1] = ans[1]*10+digit;
            index+=1;
        }       

        ans[0]*=mul;
        ans[2] = index;

        return ans;
    }


    public String fractionAddition(String expression) {

        if(expression.charAt(0) != '-')
            expression = "+"+expression;


        int idx = 0;
        int[] frac = extractNumber(expression,idx);

        int num = frac[0],den = frac[1];
        idx = frac[2];

        while(idx<expression.length()){

            frac = extractNumber(expression,idx);
            int tempNum = frac[0],tempDen = frac[1];
            idx = frac[2];
 
            if(den == tempDen)
                num+=tempNum;
            else{
                num*=tempDen;
                tempNum*=den;

                num+=tempNum;
                den*=tempDen;
            }

            if(num == 0)
                den = 1;
        }

        //System.out.println(num+" "+den);
        int gcd = GCD(Math.abs(num),den);
        num/=gcd;
        den/=gcd;

        String ans = String.valueOf(Math.abs(num))+"/"+String.valueOf(den);
        ans = (num<0?"-":"")+ans;

        return ans;

    }
}






