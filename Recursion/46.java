class Solution {
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void helper(int arr[],int idx,List<List<Integer>> res){
             if(idx == arr.length){
                List<Integer> curr = new ArrayList<>();
                for(int num:arr) curr.add(num);
                res.add(curr);
                return;
            }
            for(int i=idx;i<arr.length;i++){
                swap(arr,idx,i);
                helper(arr,idx+1,res);
                swap(arr,idx,i); // Backtrack
            }


    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res);
        return res;
        
    }
}
