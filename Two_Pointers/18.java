class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                     long sum = arr[i];
                     sum+=arr[j];
                     sum+=arr[k];
                     sum+=arr[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        res.add(temp);
                        k++;l--;
                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l] == arr[l+1]) l--;
                    }
                    else if(sum>target) l--;
                    else k++;
                    
                }
            }
        }
        return res;

    }
}
