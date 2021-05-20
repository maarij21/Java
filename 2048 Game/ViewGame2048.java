/**
 *  Author: Maarij Fatima
 *  Revised: 04-12-2021
 *  Description: viewGame2048 class
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewGame2048 extends JPanel implements KeyListener {
    GameBoard game = new GameBoard();

    static ViewGame2048 newGame = new ViewGame2048();

    static JFrame frame = new JFrame( "2048" );

    static Color green;

    String gameBoard = game.toString();

    /**
     *
     * sets up the GUI with appropriate sizes and adds a Key Listener
     */
    public static void setUpGUI() {
        frame.addKeyListener( newGame );
        frame.getContentPane().add( newGame );
        frame.setSize( 600, 500 );
        frame.setVisible( true );
        frame.setResizable( false );
    }


    /**
     * Checks to see whether wasd or arrow keys are pressed and performs the
     * appropriate actions - updates the JFrame with every move
     *
     * @param e
     *            KeyEvent to check
     */
    @Override
    public void keyPressed( KeyEvent e ) {
        if ( e.getKeyCode() == KeyEvent.VK_UP ) {
            GameRules.moveUp(game);
            GameRules.addRandomTile(game);
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyCode() == KeyEvent.VK_DOWN ) {
            GameRules.moveDown(game);
            GameRules.addRandomTile(game);
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyCode() == KeyEvent.VK_LEFT ) {
            GameRules.moveLeft(game);
            GameRules.addRandomTile(game);
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            GameRules.moveRight(game);
            GameRules.addRandomTile(game);
            gameBoard = game.toString();
            frame.repaint();
        }
        else if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
            game = new GameBoard();
            GameRules.addRandomTile(game);
            GameRules.addRandomTile(game);
            frame.repaint();
        }
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        // Not Used
    }

    @Override
    public void keyTyped( KeyEvent e ) {
        // Not Used

    }

    /**
     * Paints the GUI with a series of strings, the board, the tiles and ensures
     * they are repainted when the game is over
     *
     * @param g
     *            Graphics parameter
     */
    public void paint( Graphics g ) {
        super.paint( g );
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString( "2048", 250, 20 );
        g2.drawString( "Score: " + game.getScore(),
                200 - 4 * String.valueOf( game.getScore() ).length(),
                40 );

        g2.drawString( "Press 'Enter' to Start", 210, 315 );
        g2.drawString( "Use Arrow Keys to move", 180, 335 );

        g2.setColor( Color.lightGray );
        g2.fillRect( 146, 55, 310, 310 );
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                tileDesign( g, game.getTile(i,j), j * 77 + 150, i * 77 + 60 );
            }
        }
        if ( GameRules.isGameOver(game) ) {
            g2.drawString( "Game over :(", 250, 40 );
            g2.setColor( Color.black );
            g2.fillRect( 146, 55, 310, 310 );
            for ( int i = 0; i < 4; i++ ) {
                for ( int j = 0; j < 4; j++ ) {
                    g2.setColor( Color.black );
                    g2.fillRoundRect( j * 60 + 150, i * 60 + 60, 50, 50, 5, 5 );
                    g2.setColor( Color.black );
                }
            }
        }
    }


    /**
     *
     * draws an individual tile - called from the paint method
     *
     * @param g
     *            Graphics parameter
     * @param tile
     *            Tile to draw
     * @param x
     *            X coordinate to draw at
     * @param y
     *            Y coordinate to draw at
     */
    public void tileDesign( Graphics g, Tiles tile, int x, int y ) {
        int tileValue = tile.getValue();
        int length = String.valueOf( tileValue ).length();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor( Color.white );
        g2.fillRoundRect( x, y, 70, 70, 0, 0 );
        g2.setColor( Color.black );
        if ( tileValue > 0 ) {
            g2.setColor( tile.getColor() );
            g2.fillRoundRect( x, y, 70, 70, 0, 0 );
            g2.setColor( Color.black );
            g.drawString( "" + tileValue, x + 35 - 3 * length, y + 35 );
        }
    }


    /**
     *
     * Main method - sets up the GUI and in turn starts the whole game
     *
     * @param args
     *            default parameter
     */
    public static void main( String[] args ) {
        setUpGUI();
    }

}