import java.util.Scanner;

public class solveRPS {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String rpsGame = scan.nextLine();

        // create new instance of class solveRPS
        solveRPS game = new solveRPS();
        System.out.println(game.winner(rpsGame));
    }

    /**
     * RPS game is solved by looping the input and replacing
     * any of the 9 RPS combinations found with its winner
     * until input length is 1 and there is only 1 winner.
     */
    private String winner(String y) {
        while (y.length() != 1) {
            if (y.contains("(R&P)")) {
                y = y.replace("(R&P)", "P");
            } else if (y.contains("(R&S)")) {
                y = y.replace("(R&S)", "R");
            } else if (y.contains("(R&R)")) {
                y = y.replace("(R&R)", "R");
            } else if (y.contains("(P&R)")) {
                y = y.replace("(P&R)", "P");
            } else if (y.contains("(P&S)")) {
                y = y.replace("(P&S)", "S");
            } else if (y.contains("(P&P)")) {
                y = y.replace("(P&P)", "P");
            } else if (y.contains("(S&P)")) {
                y = y.replace("(S&P)", "S");
            } else if (y.contains("(S&R)")) {
                y = y.replace("(S&R)", "R");
            } else if (y.contains("(S&S)")) {
                y = y.replace("(S&S)", "S");
            }
        }
        return y;
    }
}
