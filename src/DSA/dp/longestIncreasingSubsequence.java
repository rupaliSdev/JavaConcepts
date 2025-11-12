package DSA.dp;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
          int[][] m ={{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(m));
    }

    public static int longestIncreasingPath(int[][] m) {
        int[][] memo = new int[m.length][m[0].length];
        int path = 0;
        int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int i =0;i<m.length;i++){
            for(int j =0;j<m[0].length;j++){
                path = Math.max(path,dfsA(i,j,dir,memo,m));

            }
        }
       return path;
    }

    private static int dfsA(int row, int col, int[][] dir, int[][] memo,int[][] m) {
        if(memo[row][col]!=0){
            return memo[row][col];
        }
        int path=1;
        for(int[] d:dir){
            int r = row+d[0],c = col+d[1];
            if(r>=0 && c>=0 && r<memo.length && c<memo[0].length && m[r][c]>m[row][col]){
                path = Math.max(path,1+dfsA(r,c,dir,memo,m));
            }

        }
        return path;
    }
}
