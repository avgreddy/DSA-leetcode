class Solution {
    public long countOfSubstrings(String word, int k) {
        return least(word,k) - least(word,k+1);
    }
    private long least(String word,int k){
        int n = word.length();
        //StringBuilder str = new StringBuilder();
        HashMap<Character,Integer> mp = new HashMap<>();
        int cc = 0;
        long res = 0;
        int j = 0;
        for(int i = 0;i<n;i++){
            //char c = word.charAt(i-w);
            char ch = word.charAt(i);
            if(isVowel(ch)){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
            else{
                cc++;
            }
            while(mp.size() == 5 && cc >= k){
                res += n - i;
                char c = word.charAt(j);
                if(isVowel(c)){
                    mp.put(c,mp.get(c)-1);
                    if(mp.get(c) == 0){
                        mp.remove(c);
                    }
                }
                else{
                    cc--;
                }
                j++;
            }
        }
        return res;
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}