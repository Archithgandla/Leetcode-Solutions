class Solution {

    public int[][] merge(int[][] intervals) {       
    List<List<Integer>> res = new ArrayList<>();
        
    //   Arrays.sort(intervals,new Comparator<int[]>(){
          
    //       public int compare(int[] start ,int[] end ){
              
    //           if(start[0] != end[0])
    //               return start[0]-end[0];
    //           return start[1]-end[1];
    //       }
    //   });
        
    
        
    int start = intervals[0][0];
    int end   = intervals[0][1];
        
    for(int i = 1;i<intervals.length;i++){
                
        if(end >= intervals[i][0] ){
            end  = Math.max(end,intervals[i][1]);
        }
        
        else{
            
            res.add(Arrays.asList(start,end));
            start = intervals[i][0];
            end = intervals[i][1];
            //System.out.println(i); 
            //System.out.println(res);        
            
    
    }
        
    
    }
    res.add(Arrays.asList(start,end));
    int[][] ans = new int[res.size()][2];
        
    for(int i=0;i<res.size();i++){
        
        ans[i][0] = res.get(i).get(0); 
        ans[i][1] = res.get(i).get(1);
        
    }
    return ans;
        
    }



    public int[][] insert(int[][] intervals, int[] newInterval) {
        //Just place the newInterval in correct position according to sorted order
        //and then use merge overlapping interval
        List<int[]> Al = new ArrayList<>();
        boolean flag = true;
        
        for(int i=0;i<intervals.length;i++){
            if(newInterval[0]<intervals[i][0] && flag){
                Al.add(newInterval);
                flag = false;
            }
            Al.add(intervals[i]);
        }

        if(flag == true)
            Al.add(newInterval);

        int[][] temp = new int[Al.size()][2];

        for(int i=0;i<Al.size();i++)
            temp[i] = Al.get(i);

        return merge(temp);
    }
}