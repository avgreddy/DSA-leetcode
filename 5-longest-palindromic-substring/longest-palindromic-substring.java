class Solution {
    int max = 0;
    int lo = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1){
            return s;
        }
        for(int i = 0;i<n;i++){
            palin(s,i,i);
            palin(s,i,i+1);
        }
        return s.substring(lo,lo+max);
    }
    public void palin(String s,int i,int j){
        //int c = 0;
        while(i>=0 && j<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            else{
                break;
            }
        }
        if(max < j-i-1){
            max = Math.max(max,j-i-1);
            lo = i+1;
        }
    }
}