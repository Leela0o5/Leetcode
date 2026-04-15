class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(0);
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<k;i++){
           while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()]){
            dq.removeLast();
           }
           dq.addLast(i);
        }
        res.add(nums[dq.getFirst()]);

        for(int i = k;i<n;i++){
            if(i-dq.getFirst()>=k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()]){
            dq.removeLast();
           }
            dq.addLast(i);
            res.add(nums[dq.getFirst()]);
        }

        int resArr[] = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            resArr[i] = res.get(i); 
        }
        return resArr;

    }
}
