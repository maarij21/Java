/**
 *  Author: Maarij Fatima
 *  Revised: 04-12-2021
 *  Description: GameBoard class
 */


public class GameBoard {

    private Tiles[][] matrix;
    private int totalScore;
    private final int matrixSize;

    /**
     * @brief A constructor for a GameBoard object with 4x4 dimensions
     * @details assume all inputs are valid
     */
    public GameBoard(){
        totalScore = 0;
        matrixSize = 4;
        matrix = new Tiles[matrixSize][matrixSize];
        for (int t=0; t<matrix.length; t++){
            for (int u=0; u<matrix[t].length; u++){
                matrix[t][u] = new Tiles();
            }
        }
    }

    /**
     * @brief returns the Tiles object at specific area of matrix
     * @param row int type for row of matrix
     * @param col int type for column of matrix
     * @return returns Tiles object
     */
    public Tiles getTile(int row, int col){
        return matrix[row][col];
    }

    /**
     * @brief gets the total score of game
     * @return int totalScore of game
     */
    public int getScore(){
        return totalScore;
    }

    /**
     * @brief adds score to total score
     * @param s int value that is added to totalScore variable
     */
    public void addScore(int s){
        totalScore += s;
    }

    /**
     * @brief gets int value at specific cell in matrix
     * @param row int row of matrix
     * @param col int col of matrix
     * @return returns int value
     */
    public int getValue(int row, int col){
        return matrix[row][col].getValue();
    }

    /**
     * @brief sets value of tile at specific place of matrix
     * @param row int row of matrix
     * @param col int column of matrix in 2D array
     * @param val the value to be set in place
     */
    public void setValue(int row, int col, int val){
        matrix[row][col].setVal(val);
    }

}