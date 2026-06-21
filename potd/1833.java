class Solution {
    public static void sort(int arr[]){
        int m = Integer.MIN_VALUE;
        for(int num:arr){
            if(num>m) m = num;
        }
        int f[] = new int[m+1];
        for(int i=0;i<arr.length;i++){
            f[arr[i]]++;
        }
        int j = 0;
        for(int i=0;i<f.length;i++){
            while(f[i]>0){
                arr[j] = i;
                j++;
                f[i]--;
            } 
        }
    }
    public int maxIceCream(int[] costs, int coins) {
        sort(costs);
        int ans = 0;
        int tmp = 0;
        for(int i=0;i<costs.length;i++){
                 if(coins>=costs[i]){
                    coins-=costs[i];
                    tmp++;
                 }else{
                    break;
                 }
        }

        return tmp;

    }
}
