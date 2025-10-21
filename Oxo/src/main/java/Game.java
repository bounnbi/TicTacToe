import java.util.Scanner;
import java.util.regex.*;

public class Game {
    private Board board;
    private Player player1, player2;
    private int compteurPlayer1, compteurPlayer2;
    private final Scanner scanner = new Scanner(System.in);
    private final Pattern pattern = Pattern.compile("^[0-2]\\s+[0-2]$");

    public Game() {
        this.board = new Board();
        this.player1 = new Player("X", Character.X);
        this.player2 = new Player("O", Character.O);
    }

    public int[] inputRegex() {
        while (true) {
            System.out.print("Entrez deux chiffres entre 0 et 2 (ex: 1 2) : ");
            String input = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                String[] parts = input.split("\\s+");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                return new int[]{x, y};
            }
            System.out.println("Entrée invalide, réessayez.");
        }
    }

    public void play() {
        while (isNotFinish()) {
            board.display();

            Player currentPlayer = (compteurPlayer1 == compteurPlayer2) ? player1 : player2;
            System.out.println("Au tour du joueur : " + currentPlayer.getName());

            int[] coords = inputRegex();
            int row = coords[0];
            int col = coords[1];

            board.completBoard(row, col, currentPlayer.getChoix());

            if (currentPlayer == player1) {
                compteurPlayer1++;
            } else {
                compteurPlayer2++;
            }
        }
        board.display();
        System.out.println("la game est fini");
    }

    public boolean isNotFinish() {
        return !board.checkWinner();
    }
}
