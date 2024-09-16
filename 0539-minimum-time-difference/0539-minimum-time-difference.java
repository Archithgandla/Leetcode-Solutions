

class Pair{
    int minutes,seconds;
    
    Pair(int minutes,int seconds){
        this.minutes = minutes;
        this.seconds = seconds;
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        Pair[] arr = new Pair[timePoints.size()];
        int minm = Integer.MAX_VALUE;
        
        for(int i=0;i<timePoints.size();i++){
            String str = timePoints.get(i);
            int minutes = (str.charAt(0)-'0')*10+(str.charAt(1)-'0');
            int seconds = (str.charAt(3)-'0')*10+(str.charAt(4)-'0');
            Pair p = new Pair(minutes,seconds);  
            arr[i] = p;
        }
        
        Arrays.sort(arr,(a,b) -> a.minutes == b.minutes?a.seconds-b.seconds:a.minutes-b.minutes);
        
        for(int i=1;i<arr.length;i++){
            int diff = (arr[i].minutes-arr[i-1].minutes)*60+(arr[i].seconds-arr[i-1].seconds);
            minm = Math.min(minm,diff>720?1440-diff:diff);
        }

        int diff = (arr[arr.length-1].minutes-arr[0].minutes)*60+(arr[arr.length-1].seconds-arr[0].seconds);
        minm = Math.min(minm,diff>720?1440-diff:diff);
        
        
        return minm;
        
    }
}



