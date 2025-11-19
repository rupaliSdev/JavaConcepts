package DSA.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        int N = 4;
        List<List<String>> queen =
        solveNQueensDFSApproach(N);
        printTheQueenArrray(queen);

        List<List<String>> queen1 = solveNQueensIIApproach(N);
        printTheQueenArrray(queen1);

    }

    private static List<List<String>> solveNQueensDFSApproach(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        fillTheBoardWithdfsApproach(0,board,res);
        return res;
    }

    private static void fillTheBoardWithdfsApproach(int col, char[][] board, List<List<String>> res) {

        if(col==board.length){
            res.add(constructBoard(board));
            return;
        }

        for(int row =0;row<board.length;row++){
            if(validate(board,row,col)){
                board[row][col]='Q';
                fillTheBoardWithdfsApproach(col+1,board,res);
                board[row][col]='.';
            }
        }
    }

    private static List<List<String>> solveNQueensIIApproach(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 board[i][j]='.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] antis = new boolean[2*n-1];
        boolean[] diag= new boolean[2*n-1];
        fillQueensInTheBoard(board,0,res,cols,antis,diag);
        return res;
    }

    private static void fillQueensInTheBoard(char[][] board, int row, List<List<String>> res, boolean[] cols, boolean[] antis, boolean[] diag) {
        int n = board.length;
        if(row==n){
            res.add(constructBoard(board));
        }
        for(int c=0;c<n;c++){
            if(!cols[c] && !diag[row-c+n-1] && !antis[row+c]){
                board[row][c]='Q';
                cols[c]=true;
                diag[row-c+n-1]=true;
                antis[row+c]=true;

                fillQueensInTheBoard(board,row+1,res,cols,antis,diag);

                board[row][c]='.';
                cols[c]=false;
                diag[row-c+n-1]=false;
                antis[row+c]=false;
            }
        }
    }

    private static void printTheQueenArrray(List<List<String>> queen) {
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }



    private static List<String> constructBoard(char[][] board) {
        int n = board.length;
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }


    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        //checking for diag
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

        //antidiag
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
