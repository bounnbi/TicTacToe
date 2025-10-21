public class Board {
    private Character[][] board;

    public Board() {
        this.board = new Character[3][3];
    }

    public void display() {
        System.out.println("--------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (isEmpty(i, j)) {
                    System.out.print("   |");
                } else {
                    System.out.print(" " + board[i][j] + " |");
                }
            }
            System.out.println("\n--------------");
        }
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == null;
    }

    public void completBoard(int row, int col, Character oxo) {
        if (isEmpty(row, col)) {
            board[row][col] = oxo;
        } else {
            System.out.println("Cette case est déjà prise !");
        }
    }


    public boolean checkDiagonales() {
        int n = board.length;
        Character firstLeft = board[0][0];
        boolean diagLeft = (firstLeft != null);
        for (int i = 1; i < n && diagLeft; i++) {
            if (board[i][i] == null || board[i][i] != firstLeft) {
                diagLeft = false;
            }
        }

        Character firstRight = board[0][n - 1];
        boolean diagRight = (firstRight != null);
        for (int i = 1; i < n && diagRight; i++) {
            if (board[i][n - 1 - i] == null || board[i][n - 1 - i] != firstRight) {
                diagRight = false;
            }
        }

        return diagLeft || diagRight;
    }

    public boolean checkColumn() {
        for (int c = 0; c < board.length; c++) {
            Character first = board[0][c];
            if (first == null) continue;

            boolean same = true;
            for (int r = 1; r < board.length; r++) {
                if (board[r][c] == null || board[r][c] != first) {
                    same = false;
                    break;
                }
            }
            if (same) return true;
        }
        return false;
    }

    public boolean checkRow() {
        for (int r = 0; r < board.length; r++) {
            Character first = board[r][0];
            if (first == null) continue;

            boolean same = true;
            for (int c = 1; c < board.length; c++) {
                if (board[r][c] == null || board[r][c] != first) {
                    same = false;
                    break;
                }
            }
            if (same) return true;
        }
        return false;
    }
    public boolean checkWinner() {
        return checkRow() || checkColumn() || checkDiagonales();
    }
}
