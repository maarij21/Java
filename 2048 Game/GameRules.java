/**
 *  Author: Maarij Fatima
 *  Revised: 04-12-2021
 *  Description: GameRules class
 */

import java.util.Arrays;
import java.util.Random;

public class GameRules {

    private final static int size = 4;
    private static int bounds = 0;

    public GameRules(){}

    /**
     * @brief start game and create initial board
     * @return board of type GameBoard
     */
    public GameBoard startGame(){
        GameBoard board = new GameBoard();
        addRandomTile(board);
        return board;
    }

    /**
     * @brief check if game is over by checking each and every cell in the 4x4 grid
     * @return Boolean
     */
    public static Boolean isGameOver(GameBoard board){
            int count = 0;
            for ( int i = 0; i < size; i++ ) {
                for ( int j = 0; j < size; j++ ) {
                    if ( board.getValue(i,j) != 0 ) {
                        if ( i == 0 && j == 0 ) {
                            if ( board.getValue(i,j) != board.getValue(i+1,j)
                                    && board.getValue(i,j) != board.getValue(i,j+1) ) {
                                count++;
                            }
                        } else if ( i == 0 && j == 3 ) {
                            if ( board.getValue(i,j) != board.getValue(i+1, j)
                                    && board.getValue(i,j) != board.getValue(i,j-1) ) {
                                count++;
                            }
                        }
                        else if ( i == 3 && j == 3 ) {
                            if ( board.getValue(i,j) != board.getValue(i-1,j)
                                    && board.getValue(i,j) != board.getValue(i,j-1) ) {
                                count++;
                            }
                        }
                        else if ( i == 3 && j == 0 ) {
                            if ( board.getValue(i,j) != board.getValue(i-1,j)
                                    && board.getValue(i,j) != board.getValue(i,j+1) ) {
                                count++;
                            }
                        }
                        else if ( i == 0 && ( j == 1 || j == 2 ) ) {
                            if ( board.getValue(i,j) != board.getValue(i+1,j)
                                    && board.getValue(i,j) != board.getValue(i, j+1)
                                    && board.getValue(i,j) != board.getValue(i,j-1) ) {
                                count++;
                            }
                        }
                        else if ( i == 3 && ( j == 1 || j == 2 ) ) {
                            if ( board.getValue(i,j) != board.getValue(i-1,j)
                                    && board.getValue(i,j) != board.getValue(i,j+1)
                                    && board.getValue(i,j) != board.getValue(i,j-1) ) {
                                count++;
                            }
                        }
                        else if ( j == 0 && ( i == 1 || i == 2 ) ) {
                            if ( board.getValue(i,j) != board.getValue(i,j+1)
                                    && board.getValue(i,j) != board.getValue(i-1,j)
                                    && board.getValue(i,j) != board.getValue(i+1,j) ) {
                                count++;
                            }
                        }
                        else if ( j == 3 && ( i == 1 || i == 2 ) ) {
                            if ( board.getValue(i,j) != board.getValue(i,j-1)
                                    && board.getValue(i,j) != board.getValue(i-1,j)
                                    && board.getValue(i,j) != board.getValue(i+1,j) ) {
                                count++;
                            }
                        }
                        else {
                            if ( board.getValue(i,j) != board.getValue(i,j-1)
                                    && board.getValue(i,j) != board.getValue(i,j+1)
                                    && board.getValue(i,j) != board.getValue(i-1,j)
                                    && board.getValue(i,j) != board.getValue(i+1,j) ) {
                                count++;
                            }
                        }
                    }
                }
            }
        return count == 16;
    }

    /**
     * @brief add random tiles to board based on a probability of getting 2 or 4
     * to a random cell in the grid that is empty
     * @param board the GameBoard object that is being played
     */
    public static void addRandomTile(GameBoard board){
        boolean empty = true;
        while ( empty ) {
            int row = (int)( Math.random() * 4 );
            int col = (int)( Math.random() * 4 );
            double x = Math.random();
            if ( board.getValue(row,col) == 0 ) {
                if ( x < 0.25 ) {
                    board.setValue(row,col,4);
                    empty = false;
                }
                else {
                    board.setValue(row,col,2);
                    empty = false;
                }
            }
        }
    }

    /**
     * @brief checks if tiles above and below are zero and if move is legal, then add score to totalScore
     * @param row int row of board
     * @param col int column of board
     * @param m KeyMove enum type for arrow keys
     * @param board GameBoard being played
     */
    public static void yMove(int row, int col, KeyMoves m, GameBoard board){
        if ( board.getValue(bounds, col) == 0 || board.getValue(bounds, col) == board.getValue(row, col) ) {
            if ( row > bounds || ((m == KeyMoves.Down) && ( row < bounds ) ) ) {
                int addScore = board.getValue(bounds, col) + board.getValue(row,col);
                if ( board.getValue(bounds, col) != 0 ) {
                    board.addScore(addScore);
                }
                board.setValue(bounds, col, addScore );
                board.setValue( row, col,0 );
            }
        }
        else {
            if ( m == KeyMoves.Down ) {
                bounds--;
            }
            else {
                bounds++;
            }
            yMove( row, col, m , board);
        }
    }

    /**
     * @brief moves tiles upwards
     * @param board type GameBoard
     */
    public static void moveUp(GameBoard board){
        for ( int i = 0; i < size; i++ ) {
        bounds = 0;
            for ( int j = 0; j < size; j++ ) {
                if ( board.getValue(j,i) != 0 ) {
                    if ( bounds <= j ) {
                        yMove( j, i, KeyMoves.Up, board );
                    }
                }
            }
        }
    }

    /**
     * @brief Moves tile downwards
     * @param board GameBoard
     */
    public static void moveDown(GameBoard board){
        for ( int i = 0; i < size; i++ ) {
            bounds = (size - 1);
            for ( int j = (size-1); j >= 0 ; j-- ) {
                if ( board.getValue(j,i) != 0 ) {
                    if ( bounds >= j ) {
                        yMove( j, i, KeyMoves.Down, board );
                    }
                }
            }
        }
    }

    /**
     * @brief checks if tiles left and right are zero and if move is legal, then add score to totalScore
     * @param row int type for row of board
     * @param col int type for column of board
     * @param m KeyMove enum type
     * @param board GameBoard being played
     */
    private static void xMove( int row, int col, KeyMoves m, GameBoard board ) {
        if ( board.getValue(row, bounds) == 0 || board.getValue(row,bounds) == board.getValue(row,col) ) {
            if ( col > bounds || ( m == KeyMoves.Right && ( col < bounds ) ) ) {
                int addScore = board.getValue(row, bounds) + board.getValue(row, col);
                if ( board.getValue(row, bounds) != 0 ) {
                    board.addScore(addScore);
                }
                board.setValue( row, bounds, addScore );
                board.setValue( row, col, 0 );
            }
        }
        else {
            if ( m == KeyMoves.Right) {
                bounds--;
            } else {
                bounds++;
            }
            xMove( row, col, m, board );
        }
    }

    /**
     * @brief move tiles left
     * @param board GameBoard
     */
    public static void moveLeft(GameBoard board) {
        for ( int i = 0; i < size; i++ ) {
            bounds = 0;
            for ( int j = 0; j < size; j++ ) {
                if ( board.getValue(i,j) != 0 ) {
                    if ( bounds <= j ) {
                        xMove( i, j, KeyMoves.Left, board );
                    }
                }
            }
        }
    }

    /**
     * @brief move tiles right
     * @param board GameBoard
     */
    public static void moveRight(GameBoard board){
        for ( int i = 0; i < size; i++ ) {
            bounds = size-1;
            for ( int j = (size-1); j >= 0; j-- ) {
                if ( board.getValue(i,j) != 0 ) {
                    if ( bounds >= j ) {
                        xMove( i, j, KeyMoves.Right, board );
                    }
                }
            }
        }
    }
}