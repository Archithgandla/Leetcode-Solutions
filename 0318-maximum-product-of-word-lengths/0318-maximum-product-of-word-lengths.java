class Solution {
    public int maxProduct(String[] words) {
        
        
        //Approach-1
        //Consider a nested loop
        //and then compare all possible pairs
        //Time complexity : O(N2 * Length(Word))

        // int maxm = Integer.MIN_VALUE;


        // for(int i=0;i<words.length;i++){

        //     for(int j=i+1;j<words.length;j++){


        //         char[] freq = new char[26];

        //         for(char c:words[i].toCharArray())
        //             freq[(int)(c-'a')] = 1;
                
        //         boolean flag = true;

        //         for(char c:words[j].toCharArray()){
        //             if(freq[(int)(c-'a')] == 1){
        //                 flag = false;
        //                 break;
        //             }
        //         }
        //         if(flag)
        //             maxm = Math.max(maxm,words[i].length()*words[j].length());
        //     }

        // }

        // return maxm == Integer.MIN_VALUE?0:maxm;

        //Approach-2
        //BIT MANIPULATION

        int[] arr = new int[words.length];

        for(int i=0;i<words.length;i++){

            String str = words[i];
            
            int num = 0;

            for(char c:str.toCharArray()){
                int temp = 1<<(int)(c-'a');
                //System.out.println(temp);
                num = (num|temp);
            }

            arr[i] = num;
        }

        //System.out.println(Arrays.toString(arr));
        int maxm = Integer.MIN_VALUE;

        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){

                if((arr[i]&arr[j]) != 0)
                    continue;
                maxm = Math.max(maxm,words[i].length()*words[j].length());
            }
        }

        return maxm == Integer.MIN_VALUE?0:maxm;



    }
}

