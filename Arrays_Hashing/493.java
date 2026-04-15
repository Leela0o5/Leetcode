class Solution {
    public int mergeSort(int arr[],int low,int high){
        int count = 0;
        if(low<high){
            int mid = (low+high)/2;
            count+=mergeSort(arr,low,mid);
            count+=mergeSort(arr,mid+1,high);
            count+=merge(arr,low,mid,high);
        }
        return count;
    }
    public int merge(int arr[],int low,int mid,int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int count=0;
        int i=0,j=0,k=low;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int p=0;p<n1;p++){
            left[p] = arr[low+p];
        }
        for(int p=0;p<n2;p++){
            right[p] = arr[mid+p+1];
        }

        while(i<n1){
            while(j<n2 && left[i] > 2L*right[j]){
                j++;
            }
            count+=j;
            i++;
        }

        i=0;
        j=0;

         while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
             arr[k++] = right[j++];
        }
        return count;

    }
    public int reversePairs(int[] nums) {
        int ans = mergeSort(nums,0,nums.length-1);
        return ans;
    }
}
