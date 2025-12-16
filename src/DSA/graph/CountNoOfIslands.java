package DSA.graph;

public class CountNoOfIslands {

    public static void main(String[] args) {

    }

    public static int numOfIslands(char[][] g ){
        int m= g.length,n=g[0].length,count=0;
        for (int i=0;i<m;i++)for(int j=0;j<n;j++) if(g[i][j]=='1'){count++;dfsa(i,j,g,m,n);}
        return count;
    }

    private static void dfsa(int r, int c, char[][] g, int m, int n) {
          g[r][c]='0';//marking as visited

        for(int delrow = -1; delrow<=1;delrow++) {
            for(int delcol = -1; delcol <= 1; delcol++) {
                int nrow = r + delrow;
                int ncol = c + delcol;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && g[nrow][ncol] == '1') {
                    dfsa(nrow,ncol,g,m,n);
                }
            }
        }
    }
}

