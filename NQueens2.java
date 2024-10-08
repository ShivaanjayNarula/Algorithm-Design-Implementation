/*
LeetCode - 52
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */

import java.util.*;
public class NQueens2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        List<List<String>> ans = new ArrayList<>();
        helper(board, 0, ans);
        System.out.print(ans.size());
    }

    public static void helper(List<String> board, int row, List<List<String>> ans) {
        int n = board.size();
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isSafe(board, row, i)) {
                String str = board.get(row).substring(0, i) + 'Q' + board.get(row).substring(i+1);
                board.set(row, str);
                helper(board, row + 1, ans);
                str = board.get(row).substring(0, i) + '.' + board.get(row).substring(i+1);
                board.set(row, str);
            }
        }
    }

    public static boolean isSafe(List<String> board, int row, int col) {
        int n = board.size();
        for (int i = 0; i < row; i++) {
            if(board.get(i).charAt(col) == 'Q')
            {
                return false;
            }
        }
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if(board.get(row - i).charAt(col - i) == 'Q')
            {
                return false;
            }
        }
        for (int i = 1; row - i >= 0 && col + i < n; i++) {
            if(board.get(row - i).charAt(col + i) == 'Q')
            {
                return false;
            }
        }
        return true;
    }
}