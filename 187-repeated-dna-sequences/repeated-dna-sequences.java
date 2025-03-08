class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> st = new HashSet<>();
        int n = s.length();
        for(int i = 0;i <= n-10;i++){
            String str = s.substring(i,i+10);
            if(st.contains(str) && !ans.contains(str)){
                ans.add(str);
            }
            st.add(str);
        }
        return ans;
    }
}