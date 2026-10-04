package dp;

public class ValidParenthesesGridWithDP {

    // memorization, 1 represents true, 2 represents false, 0 mean unvisited
    // memo[row][col][balance]
    private int[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // if total cells in the path is odd, we can never pair them up evenly
        if ((m + n -1) % 2 != 0) {
            return false;
        }

        // can not start with ')' and end with '('
        if (grid[0][0] == ')' || grid[m-1][n-1] == '(') {
            return false;
        }

        // max possible balance is the maximum steps we can take (m +n)
        memo = new int[m][n][m+n];

        return explore(grid, 0, 0, 0);
    }

    private boolean explore(char[][] grid, int r, int c, int balance) {
        // out of bounds check
        if ( r== grid.length || c == grid[0].length) {
            return false;
        }

        // update balance
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // invalid path state
        if (balance < 0 || balance >= memo[0][0].length) {
            return false;
        }

        // check if we hit the destination
        if (r == grid.length-1 && c == grid[0].length -1) {
            return balance == 0;
        }

        // DP notebook check, if we already solved this state, return it
        if (memo[r][c][balance] != 0) {
            return memo[r][c][balance] == 1;
        }

        // explore choices
        boolean moveDown = explore(grid, r +1, c, balance);
        boolean moveRight = explore(grid, r, c+1, balance);
        boolean result = moveDown || moveRight;

        // save the result to our DP notebook before returning
        memo[r][c][balance] = result ? 1 : 2;

        return result;
    }
}
