class Solution {
    public boolean canAliceWin(int n) {

        boolean flag = true;int count = 10;

        while(true){
            if(count>n)
                return !flag;

            n-=count;
            count-=1;
            flag = !flag;
        }




    }
}

