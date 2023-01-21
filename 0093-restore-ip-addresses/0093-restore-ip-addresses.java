class Solution {

    void Util(String s,int dots,String str,int index,List<String> li){
        // System.out.println(dots+" "+index);
        // System.out.println(str);
        if(dots == 4 && index == s.length()){
            //System.out.println("hi");
            li.add(str.substring(0,str.length()-1));
            return;
        }

        if(dots>4 || index>=s.length())
            return;


        //Taking one character
        Util(s,dots+1,str+s.substring(index,index+1)+".",index+1,li);

        //Taking double digit
        if(s.charAt(index) != '0' && index+1<s.length()){
            Util(s,dots+1,str+s.substring(index,index+2)+".",index+2,li);
        }
        //Taking triple digit
        if(s.charAt(index) != '0' &&index+2<s.length() && Integer.valueOf(s.substring(index,index+3))<=255)
            Util(s,dots+1,str+s.substring(index,index+3)+".",index+3,li);

    }


    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4 || s.length()>12)
            return new ArrayList<String>();

        List<String> Al = new ArrayList<String>();
        Util(s,0,"",0,Al);

        return Al;
    }
}