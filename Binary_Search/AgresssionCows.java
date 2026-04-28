import java.util.*;

class Solution {

    public boolean canHaveCows(int arr[], int dist, int cows) {

        int cntCows = 1;
        int lastCow = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastCow >= dist) {
                cntCows++;
                lastCow = arr[i];
            }
        }

        return cntCows >= cows;
    }

    public int aggressiveCows(int arr[], int cows) {

        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canHaveCows(arr, mid, cows)) {
                ans = mid;
                low = mid + 1; // try bigger distanc
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
