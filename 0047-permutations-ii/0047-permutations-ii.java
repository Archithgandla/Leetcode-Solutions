class Solution {
    
    public void Util(int[] nums,List<Integer> arr,HashSet<List<Integer>> ans,int index,boolean[] visited){
        if(index == nums.length){
            ArrayList<Integer> temp = new ArrayList<>(arr);
            ans.add(temp);
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                arr.add(nums[i]);
                visited[i] = true;
                Util(nums,arr,ans,index+1,visited);
                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }
        
    }
       
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Util(nums,new ArrayList<>(),ans,0,new boolean[nums.length]); 
        
        List<List<Integer>> li = new ArrayList<>(ans);
        return li;
    }
}