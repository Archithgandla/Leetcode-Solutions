class Solution {
    
    public void Util(int[] nums,int index,List<Integer> li,List<List<Integer>> Al){

        if(index == nums.length){
            Al.add(new ArrayList<>(li));
            return;
        }


        //Not take
        Util(nums,index+1,li,Al);

        //Take
        li.add(nums[index]);
        Util(nums,index+1,li,Al);
        li.remove(li.size()-1);

        return;
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> Al = new ArrayList<>();

        Util(nums,0,new ArrayList<Integer>(),Al);

        return Al;

    }
}


