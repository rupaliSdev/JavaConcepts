package DSA.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    public static List<List<String>> solveNQueens(int n) {


        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();


        boolean[] cols=new boolean[n];
        boolean[] antis = new boolean[2*n-1];
        boolean[] diag= new boolean[2*n-1];
        nQueens(board, 0, cols, antis, diag,res);


        List<List<String>> res1 = new ArrayList<>();

        dfs(0, board, res1);
        return res;
    }

    public static void nQueens(char[][] board, int x , boolean[] cols, boolean[] antis , boolean[] diag, List<List<String>> res) {
        int n= board.length;
        if(x==n){
            res.add(constructBoard(board));
            return;
        }

        for( int y =0 ;y<n;y++){
            if(!cols[y] && !diag[x-y+n-1] && !antis[x+y] ) {

                board[x][y] = 'Q';
                cols[y] = true;
                diag[x - y + n - 1] = true;
                antis[x + y] = true;

                nQueens(board, x + 1, cols, antis, diag, res);

                board[x][y] = '.';
                cols[y] = false;
                diag[x - y + n - 1] = false;
                antis[x + y] = false;

            }
        }





    }

    private static List<String> constructBoard(char[][] board) {
        int n= board.length;
        List < String > res = new LinkedList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }


    static void dfs(int col, char[][] board, List < List < String >> res) {
        if (col == board.length) {
            res.add(constructBoard(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }
    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
}
