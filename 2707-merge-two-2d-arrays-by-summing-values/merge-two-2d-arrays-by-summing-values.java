class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i < n1;i++){
            mp.put(nums1[i][0],nums1[i][1]);
        }
        for(int i = 0;i < n2;i++){
            mp.put(nums2[i][0],mp.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        }
        int[][] ans = new int[mp.size()][2];
        List<Integer> l = new ArrayList<>(mp.keySet());
        Collections.sort(l);
        int k = 0;
        for(int i : l){
            ans[k][0] = i;
            ans[k][1] = mp.get(i);
            k = k+1;
        }
        return ans;
    }
}