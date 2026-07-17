class Solution {
    public void sort(int nums[],int s,int e){
        if(s<e){
            int m = s + (e-s)/2;
            sort(nums,s,m);
            sort(nums,m+1,e);
            merge(nums,s,e,m);
        }

    }

    public void merge(int nums[],int s,int e,int m){
        int n1 = m-s+1;
        int n2 = e-m;
        int l[] = new int[n1];
        int r[] = new int[n2];
        int k = s;
        int h = 0,j=0;
        for(int i=0;i<n1;i++){
            l[i] = nums[s+i];
        }
        for(int i=0;i<n2;i++){
            r[i] = nums[m+i+1];
        }
        while(h<n1 && j<n2){
            if(l[h]<=r[j]){
                nums[k++]  = l[h++];
            }
            else{
                nums[k++] = r[j++];
            }
        }
         while(h<n1){
            nums[k++] = l[h++];
        }
        while(j<n2){
            nums[k++] = r[j++];
        }  
    }
    public int[] sortArray(int[] nums) {
           sort(nums,0,nums.length-1);
           return nums;
    }
}
