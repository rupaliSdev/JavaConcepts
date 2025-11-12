package DSA.dp;


//A taxi can take multiple passengers to the railway station at the same time.On the way back to the starting point,the taxi driver may pick up additional passengers for his next trip to the airport.A map of passenger location has been created,represented as a square matrix.
//
//The Matrix is filled with cells,and each cell will have an initial value as follows:
//
//A value greater than or equal to zero represents a path.
//A value equal to 1 represents a passenger.
//A value equal to -1 represents an obstruction.
//The rules of motion of taxi are as follows:
//
//The Taxi driver starts at (0,0) and the railway station is at (n-1,n-1).Movement towards the railway station is right or down,through valid path cells.
//After reaching (n-1,n-1) the taxi driver travels back to (0,0) by travelling left or up through valid path cells.
//When passing through a path cell containing a passenger,the passenger is picked up.once the rider is picked up the cell becomes an empty path cell.
//If there is no valid path between (0,0) and (n-1,n-1),then no passenger can be picked.
//The goal is to collect as many passengers as possible so that the driver can maximize his earnings.
//For example consider the following grid,
//
//           0      1
//                   -1     0
//
//Start at top left corner.Move right one collecting a passenger. Move down one to the destination.Cell (1,0) is blocked,So the return path is the reverse of the path to the airport.All Paths have been explored and one passenger is collected.
//
//Returns:
//
//Int:maximum number of passengers that can be collected.
//Sample Input 0
//
//        4  -> size n = 4
//4 -> size m = 4
//0 0 0 1 -> mat
//1 0 0 0
//        0 0 0 0
//        0 0 0 0
//Output 0
//
//        2
//Explanation 0
//
//The driver can contain a maximum of 2 passengers by taking the following path
//        (0,0) → (0,1) → (0,2) → (0,3) → (1,3) → (2,3) → (3,3) → (3,2) → (3,1) → (3,0) → (2,0) → (1,0)  → (0,0)
//
//Sample Input 1
//
//STD IN                  Function
//
//————              ————-
//
//        3     →  size  n=3
//   3    →  size m=3
//   0 1 -1 → mat
//   1 0 -1
//           1 1 1
//Sample Output 1
//
//        5
//Explanation 1
//
//The driver can contain a maximum of 5 passengers by taking the following path
//        (0,0) → (0,1) → (1,1) → (2,1) → (2,2) → (2,1) → (2,0) → (1,0) → (0,0)
public class Passenger {

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1,  1}
        };

        System.out.println(maxPickUp(grid));
    }

    private static int maxPickUp(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid.length];
        int ans = solve(grid.length,grid[0].length,0,0,0,grid,dp);
        return ans;

    }

    public static int solve(int n,int m ,int r1,int r2,int c1,int[][] grid,int[][][] dp){
        int c2= r1+c1-r2;
        // Reached bottom-right (both)
        if (r1 == n - 1 && c1 == m - 1 && r2 == n - 1 && c2 == m - 1) {
            return grid[r1][c1];
        }

        if (r1 >= n || r2 >= n || c2 >= m|| c1>=m) return Integer.MIN_VALUE;

        if(grid[r1][c1]==-1 || grid[r2][c2]==-1) {
            return Integer.MIN_VALUE;
        }




        if(dp[r1][c1][r2]!=0){
            return dp[r1][c1][r2];
        }

        int res =grid[r1][c1];
        if(r1!=r2 && c1!=c2) res+=grid[r2][c2];

        int bestNext =Math.max(Math.max(solve(n,m,r1+1,r2+1,c1,grid,dp),//down,down
                        solve(n,m,r1+1,r2,c1,grid,dp)),// down,right

                Math.max(solve(n,m,r1,r2,c1+1,grid,dp) //right,right

                        ,solve(n,m,r1,r2+1,c1+1,grid,dp)));//right, down

        res+=bestNext;
        dp[r1][c1][r2]=res;
        return res;
    }
}
