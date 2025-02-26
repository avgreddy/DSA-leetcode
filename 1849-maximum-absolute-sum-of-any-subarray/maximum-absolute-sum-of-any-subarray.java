class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int mx = 0,mn = 0;
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            if(sum > mx){
                mx = sum;
            }
            if(sum < mn){
                mn = sum;
            }
        }
        return Math.abs(mx-mn);
    }
}