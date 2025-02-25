class Solution {
    public int numOfSubarrays(int[] arr) {
        long[] a = new long[arr.length];
        int n = arr.length;
        a[0] = arr[0];
        long c = 0;
        if(a[0]%2 != 0){
            c++;
        }
        for(int i = 1;i<n;i++){
            a[i] = arr[i]+a[i-1];
            if(a[i]%2 != 0){
                c++;
            }
        }
        c += (n-c)*c;
        return (int)(c%1000_000_007);
    }
}