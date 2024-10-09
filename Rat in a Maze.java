/*
Not in a mood to write the main class just ask chatgpt for the help
I am too sick for this shit today
*/

class Solution {
    ArrayList<String> arr = new ArrayList<>();

    public void helper(int[][] mat, int r, int c, String cur) {
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            arr.add(cur);
            return;
        }

        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != 1) {
            return;
        }

        int temp = mat[r][c];
        mat[r][c] = 2;

        helper(mat, r, c + 1, cur + "R");
        helper(mat, r + 1, c, cur + "D");
        helper(mat, r, c - 1, cur + "L");
        helper(mat, r - 1, c, cur + "U");

        mat[r][c] = temp;
    }

    public ArrayList<String> findPath(int[][] mat) {
        if (mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
            return arr;
        }

        helper(mat, 0, 0, "");
        return arr;
    }
}
