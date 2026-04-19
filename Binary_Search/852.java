class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int m = s+(e-s)/2;
        while(s<e){
            if(arr[m+1]>arr[m]) s = m+1;
            else e = m;
            m = s+(e-s)/2;
        }
        return s;
    }
}
