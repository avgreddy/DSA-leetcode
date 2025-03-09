class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] ans = new int[n+k-1];
        for(int i = 0;i<n;i++){
            ans[i] = colors[i];
        }
        for(int i = 0;i<k-1;i++){
            ans[i+n] = colors[i];
        }
        int res = 0;
        int l = 0;
        int r = 1;
        while(r < ans.length){
            if(ans[r] == ans[r - 1]){
                l = r;
                r++;
                continue;
            }
            r++;
            if(r-l < k) continue;
            res++;
            l++;
        }
        return res;
    }
}