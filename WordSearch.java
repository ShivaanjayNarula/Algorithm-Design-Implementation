/*
LeetCode-79

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically
neighboring.
The same letter cell may not be used more than once.
 */

import java.util.*;
public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] board = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();
        boolean check = false;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helper(i, j, board, word, 0))
                {
                    check = true;
                    break;
                }
            }
        }
        System.out.print(check);
    }
    public static boolean helper(int row, int col, char[][] board, String word, int id) {
        int m = board.length;
        int n = board[0].length;
        if(id == word.length())
        {
            return true;
        }
        if(row < 0 || row >= m || col < 0 || col >= n)
        {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '!';
        boolean check = helper(row + 1, col, board, word, id+1) || helper(row, col+1, board, word, id+1) || helper(row-1, col, board, word, id+1) || helper(row, col-1, board, word, id+1);
        board[row][col] = temp;
        return check;
    }
}