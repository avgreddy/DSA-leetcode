class UFDS{
    int n;
    int[] parent;
    int count;
    public UFDS(int n){
        this.n = n;
        parent = new int[n];
        count = n;
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
    }
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    void merge(int x,int y){
        int rx = find(x);
        int ry = find(y);
        if(rx == ry){
            return;
        }
        parent[ry] = rx;
        count--;  
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UFDS ds = new UFDS(n);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(isConnected[i][j] == 1){
                    ds.merge(i,j);
                }
            }
        }
        return ds.count;
    }
}