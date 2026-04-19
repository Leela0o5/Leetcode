class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 0;
        int n  = nums.length;
        int e = nums.length-1;
        if(n == 1) return nums[0];
        while(s<=e){
            int m = s+(e-s)/2;
            if(m == 0 && nums[0]!=nums[1]) return nums[m];
            if(m == n-1 && nums[n-1]!=nums[n-2]) return nums[m];
            if(nums[m-1]!=nums[m] && nums[m] != nums[m+1]) return nums[m];
            if(m%2 == 0){
                if(nums[m-1] == nums[m]) e = m-1;
                else s = m+1;
            }
            else{
                  if(nums[m-1] == nums[m]) s = m+1;
                  else e = m-1;
            }
        }

      return -1;
        }

    }
