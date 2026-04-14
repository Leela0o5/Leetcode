class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                count+=1;
            }
            int remVal = sum-k;
            if(map.containsKey(remVal)){
                count+= map.get(remVal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
