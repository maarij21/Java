import java.util.Scanner;

public class gameValidator {
    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);
        String input = scanInput.nextLine();

        // create new instance of class gameValidator
        gameValidator game = new gameValidator();

        if (!game.containsValidChars(input)) {
            // game does not contain VALID chars ex: (A&B)
            System.out.println("INVALID");
        } else if (game.keepWinner(input).length() == 1){
            // length of input is 1 so there is a winner and input is VALID
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }
    }

    /**
     * checks that input is INVALID by
     * iterating through every char in the input.
     * if string "RPS&()" does not contain every char
     * then input is INVALID and returns false.
     */
    private boolean containsValidChars(String x) {
        for (int i = 0; i < x.length(); i++ ) {
            char var = x.charAt(i);
            String validChars = "RPS&()";
            if (validChars.contains(String.valueOf(var))) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks if input is VALID by ultimately solving the game.
     * Input is kept in a loop until its length is
     * simplified to 1: meaning the game is resolved.
     */
    private String keepWinner(String y) {
        while (y.length() != 1) {
            /* check if input contains any of the 9 RPS combinations
             and replace that combination in the input with its winner */
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
                /* break out of loop if input does not contain any VALID RPS combination.
                Hence input is INVALID. */
            } else if (!y.contains("(R&P)") || !y.contains("(R&S)")
                    || !y.contains("(R&R)") || !y.contains("(P&R)")
                    || !y.contains("(P&S)") || !y.contains("(P&P)")
                    || !y.contains("(S&P)") || !y.contains("(S&R)")
                    || !y.contains("(S&S)") )
            {
                break;
            }
        }
        return y;
    }
}

