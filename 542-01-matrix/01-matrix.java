class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[r][c];
        int[][] res = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    //vis[i][j] = 1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.remove();
            int i = p.i;
            int j = p.j;
            int d = p.d;
            dist[i][j] = d;
            for(int k = 0;k<4;k++){
                int ni = i+di[k];
                int nj = j+dj[k];
                if(ni >= 0 && nj >= 0 && ni<r && nj<c && mat[ni][nj] == 1 && res[ni][nj] == 0){
                    res[ni][nj] = res[i][j] + 1;
                    q.add(new Pair(ni,nj,d+1));
                }
            }

        }
        return dist;
    }
}
class Pair{
    int i,j,d;
    public Pair(int i,int j,int d){
        this.i = i;
        this.j = j;
        this.d = d;
    }
}