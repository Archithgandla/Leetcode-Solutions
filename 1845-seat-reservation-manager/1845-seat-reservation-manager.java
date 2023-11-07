class SeatManager {

    int[] arr;
    int prev = 1;

    public SeatManager(int n) {
        arr = new int[n+1];
        prev = 1;
    }
    
    public int reserve() {


        //System.out.println("reserve : "+prev);        
        arr[prev] = 1;
        int temp = prev;

        int i;
        for(i=prev;i<arr.length;i++){
            
            //System.out.println(i);
            
            if(arr[i] == 0){
                prev = i;
                //System.out.println("hi");
                break;
            }
        }


        //To handle the when no free space found,but free space might be
        //formed when someone leaves, and that left seat should satisfy minm
        //condition
        if(i == arr.length)
            prev = Integer.MAX_VALUE;

        //System.out.println(Arrays.toString())
        return temp;

    }
    
    public void unreserve(int seatNumber) {
        //System.out.println("unreserve : "+seatNumber);
        arr[seatNumber] = 0;
        prev = Math.min(prev,seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */