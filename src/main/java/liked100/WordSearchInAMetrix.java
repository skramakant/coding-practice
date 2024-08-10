package liked100;

import java.util.LinkedList;


// https://leetcode.com/problems/word-search/
public class WordSearchInAMetrix {

    int[] xx = new int[]{1, 0, -1, 0};
    int[] yy = new int[]{0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {

        if(word.length() == 1) {

            if(board[0][0] == word.charAt(0)) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                {

                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                    //System.out.println(board[i][j] + " : "+word.charAt(0));
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int wordIndex) {
        if(wordIndex == word.length()) return true;

        if(x<0 || x >= board.length || y < 0 || y >= board[0].length) return false;

        if(board[x][y] != word.charAt(wordIndex)) return false;

        board[x][y] ^= 256; //xor

        boolean result = false;

        for(int i =0; i<4; i++) {
            result = result || dfs(board, word, x + xx[i], y + yy[i], wordIndex+1);
        }

        board[x][y] ^= 256; //xor

        return result;
    }

    // bfs not working because, from diff path it can visit same element
    // here we need to use dfs with backtrack
    private boolean findWord(Cell firstCell, char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        LinkedList<Cell> queue = new LinkedList<>();
        queue.addLast(firstCell);
        visited[firstCell.getI()][firstCell.getJ()] = 1;
        while (!queue.isEmpty()) {
            Cell cell = queue.removeFirst();
            if (cell.getMatchWord().equals(word)) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ii = xx[i] + cell.getI();
                int jj = yy[i] + cell.getJ();

                if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && visited[ii][jj] != 1) {
                    String nextWord = cell.getMatchWord() +  board[ii][jj];
                    if(nextWord.equals(word)) {
                        return true;
                    }
                    if (word.contains(nextWord)) {
                        visited[ii][jj] = 1;
                        queue.add(new Cell(ii, jj, nextWord));
                    }else{
                        visited[cell.getI()][cell.getJ()] = 0;
                    }
                }
            }

        }

        return false;
    }

    private class Cell {
        int i, j;

        String matchWord;

        public Cell(int i, int j, String matchWord) {
            this.i = i;
            this.j = j;
            this.matchWord = matchWord;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public String getMatchWord() {
            return matchWord;
        }
    }
}
