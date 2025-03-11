class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < n1; i++) {
            l.add(nums1[i]);
        }
        for (int i = 0; i < n2; i++) {
            l.add(nums2[i]);
        }
        Collections.sort(l);
        int n = l.size();
        if (n % 2 != 0) {
            return 1.0 * l.get(n / 2);
        }
        return 1.0 * (l.get((n / 2) - 1) + l.get(n / 2)) / 2;
    }
}