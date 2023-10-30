
class Pair{
    int num,count;

    Pair(int num,int count){
        this.num = num;
        this.count = count;
    }
}



class Solution {
    public int[] sortByBits(int[] arr) {

        Pair[] temp = new Pair[arr.length];

        for(int i=0;i<arr.length;i++){

            int num = arr[i],count = 0;

            while(num>0){
                int rsbm = num&(-num);
                num = num-rsbm;
                count+=1;
            }
            //System.out.println(count);
            temp[i] = new Pair(arr[i],count);
        }

        Arrays.sort(temp,(a,b) -> a.count == b.count?a.num-b.num:a.count-b.count);

        //System.out.println(Arrays.toString(arr));

        for(int i=0;i<temp.length;i++)
            arr[i] = temp[i].num;
        
        //System.out.println(Arrays.toString(arr));
        
        return arr;

    }
}

