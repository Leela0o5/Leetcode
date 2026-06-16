class Solution {
    public static void backtrack(List<List<Integer>> res,int[] nums,int start,List<Integer> curr){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(res,nums,i+1,curr);
            curr.remove(curr.size()-1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;
        backtrack(res,nums,start,new ArrayList<>());
        return res;
    }
}
