class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    public void solve(char[][] b) {
        int r = b.length;
        int c = b[0].length;
        for(int i = 0;i<r;i++){
            if(b[i][0] == 'O'){
                dfs(b,r,c,i,0);
            }
        }
        for(int j = 0;j<c;j++){
            if(b[0][j] == 'O'){
                dfs(b,r,c,0,j);
            }
        }
        for(int i = 0;i<r;i++){
            if(b[i][c-1] == 'O'){
                dfs(b,r,c,i,c-1);
            }
        }
        for(int j = 0;j<c;j++){
            if(b[r-1][j] == 'O'){
                dfs(b,r,c,r-1,j);
            }
        }
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(b[i][j] == 'Y'){
                    b[i][j] = 'O';
                }
                else if(b[i][j] == 'O'){
                    b[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] b,int r,int c,int i,int j){
        if(i<0 || j<0 || i>=r || j>=c || b[i][j] != 'O'){
            return;
        }
        b[i][j] = 'Y';
        for(int k = 0;k<4;k++){
            dfs(b,r,c,i+di[k],j+dj[k]);
        }
    }
}