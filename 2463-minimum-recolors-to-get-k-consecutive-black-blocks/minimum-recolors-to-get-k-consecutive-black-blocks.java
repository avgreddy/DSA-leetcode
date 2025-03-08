class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int b_count = 0;
        int w_count = 0;
        for(int i = 0;i<k;i++){
            if(blocks.charAt(i) == 'B'){
                b_count++;
            }
        }
        if(b_count == k){
            return w_count;
        }
        else{
            w_count = k-b_count;
        }
        int mn = w_count;
        for(int i = k;i<n;i++){
            if(blocks.charAt(i-k) == 'B'){
                b_count--;
            }
            else{
                w_count--;
            }
            if(blocks.charAt(i) == 'B'){
                b_count++;
            }
            else{
                w_count++;
            }
            if(b_count == k){
                return 0;
            }
            mn = Math.min(mn,w_count);
        }
        return mn;
    }
}