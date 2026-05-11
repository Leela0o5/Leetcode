class Solution {
    public void cs(int[] arr, int i, ArrayList<Integer> combinations, List<List<Integer>> ans, int target) {
        if (target == 0) {
            if(!ans.contains(new ArrayList<>(combinations))){
            ans.add(new ArrayList<>(combinations));
            return;
        }
        }

        if (i == arr.length || target < 0) {
            return;
        }

        combinations.add(arr[i]);
        cs(arr, i + 1, combinations, ans, target - arr[i]);
        
        // Backtrack
        combinations.remove(combinations.size() - 1);
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }
        cs(arr, i + 1, combinations, ans, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        cs(candidates, 0, new ArrayList<>(), ans, target);
        return ans;
    }
}
