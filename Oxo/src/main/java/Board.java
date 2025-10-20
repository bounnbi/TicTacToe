/**
 * here is the Board of the game
 */

public class Board {
    /**
     * here we initialize the board
     */
    private Character[][] board;


    /**
     * tic-tac-toe is a 3*3 Boardgame
     */
    public Board() {
        this.board = new Character[3][3];
    }

    /**
     * so we display the board
     */
    public void display() {
        System.out.println("--------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                // Si la case est vide, on affiche un espace sinon la valeur
                if (isEmpty(i,j)) {
                    System.out.print("   |");
                } else {
                    System.out.print(" " + board[i][j] + " |");
                }
            }
            System.out.println("\n--------------");
        }
    }

    /**
     * @param col
     * @param row
     * we need a methode that return when the board on the position [row][col] is initialized
     */
    public boolean isEmpty(int row,int col){
        if (board[row][col] != null){
            return false;
        }
        return true;
    }

    /**
     * @param row
     * @param col
     * @param oxo
     *
     * we completed the board on position [row][col] is not initialized
     */
    public void completBoard(int row , int col,Character oxo){
        if(isEmpty(row, col)){
            board[row][col]=oxo;
        }
    }

    public boolean checkWinner() {
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == null) continue;

            if (board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
                return true;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == null) continue;

            if (board[0][c] == board[1][c] && board[1][c] == board[2][c]) {
                return true;
            }
        }
        return false;
    }
}
