package dp;

public class ValidParenthesesGridWithOutDP {

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // if total cells in the path is odd, we can never pair them up even
        if ((m + n -1) % 2 != 0) {
            return false;
        }

        // can not start with ')' or end with '('
        if (grid[0][0] == ')' || grid[m-1][n-1] == '(') {
            return false;
        }

        return explore(grid, 0, 0, 0);
    }

    private boolean explore(char[][] grid, int r, int c, int balance) {

        // out of boundary
        if ( r == grid.length || c == grid[0].length) {
            return false;
        }

        // update balance based on current cell
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }


        // if balance becomes zero, it means we have an unmatched
        if (balance < 0) {
            return false;
        }

        if (r == grid.length-1 && c ==grid[0].length-1) {
            return balance == 0; // if balance is zero return true, else false
        }

        // try going down or going right

        boolean moveDown = explore(grid, r + 1, c, balance);

        boolean moveRight = explore(grid, r, c +1 , balance);

        return moveDown || moveRight;
    }

    public static void main(String[] args) {
        ValidParenthesesGridWithOutDP solution = new ValidParenthesesGridWithOutDP();

        // Test case 1: valid path exists -> expected: true
        // Grid:
        // ( (
        // ) )
        // One valid path: (0,0)->(1,0)->(1,1) = "())" — nope
        // Another path:   (0,0)->(0,1)->(1,1) = "(())" — wait, that's 3 cells
        // Path length = m+n-1 = 2+2-1 = 3 (odd), so should return false
        char[][] grid1 = {
            {'(', '('},
            {')', ')'}
        };
        System.out.println("Test 1 (2x2, expected false - odd path length): " + solution.hasValidPath(grid1));

        // Test case 2: 2x3 grid with a valid path -> expected: true
        // Grid:
        // ( ( (
        // ) ) )
        // Path (0,0)->(0,1)->(1,1)->(1,2) = "(())" -> valid!
        char[][] grid2 = {
            {'(', '(', '('},
            {')', ')', ')'}
        };
        System.out.println("Test 2 (2x3, expected true):  " + solution.hasValidPath(grid2));

        // Test case 3: no valid path -> expected: false
        // Grid:
        // ( )
        // ) (
        // Path (0,0)->(0,1)->(1,1) = "()(", balance ends at 1 -> false
        // Path (0,0)->(1,0)->(1,1) = "()(", balance goes negative -> false
        char[][] grid3 = {
            {'(', ')'},
            {')', '('}
        };
        System.out.println("Test 3 (2x2, expected false - no valid path): " + solution.hasValidPath(grid3));

        // Test case 4: starts with ')' -> expected: false (early exit)
        char[][] grid4 = {
            {')', '(', '('},
            {'(', ')', ')'}
        };
        System.out.println("Test 4 (starts with ')', expected false): " + solution.hasValidPath(grid4));

        // Test case 5: 1x1 grid with single '(' -> expected: false (odd path length)
        char[][] grid5 = {{'('}};
        System.out.println("Test 5 (1x1 single '(', expected false): " + solution.hasValidPath(grid5));
    }
}
