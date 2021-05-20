/**
 *  Author: Maarij Fatima
 *  Revised: 04-12-2021
 *  Description: Tiles class
 */

import java.awt.Color;

public class Tiles {

    private int tValue;
    Color tileColor;

    /**
     * @brief A constructor for a Tiles object with value 0
     * @details assume all inputs are valid
     */
    public Tiles(){
        tValue = 0;
    }

    /**
     * @brief A constructor for a Tiles object with value v
     * @param v int param to set value of Tiles object
     * @details assume all inputs are valid
     */
    public Tiles(int v){
        tValue = v;
    }

    /**
     * @brief get the value of Tiles object
     * @return tile value of type int
     */
    public int getValue(){
        return tValue;
    }

    /**
     * @brief set the value of a Tiles object
     * @param v type int param to set for Tiles object
     */
    public void setVal(int v){
        tValue = v;
    }

    /**
     * @brief sets color of specific tiles by their value
     */
    public void setColor() {
        if ( this.getValue() == 2 ) {
            tileColor = new Color(192, 226, 136, 185);
        }
        else if ( this.getValue() == 4 ) {
            tileColor = new Color(255, 160, 181, 255);
        }
        else if ( this.getValue() == 8 ) {
            tileColor = new Color(119, 85, 220, 168);
        }
        else if ( this.getValue() == 16 ) {
            tileColor = new Color(36, 96, 160, 148);
        }
        else if ( this.getValue() == 32 ) {
            tileColor = new Color(127, 196, 155, 158);
        }
        else if ( this.getValue() == 64 ) {
            tileColor = new Color(240, 59, 246, 168);
        }
        else if ( this.getValue() == 128 ) {
            tileColor = new Color(98, 167, 239, 255);
        }
        else if ( this.getValue() == 256 ) {
            tileColor = new Color(158, 209, 246, 146);
        }
        else if ( this.getValue() == 512 ) {
            tileColor = new Color( 237, 80, 198, 139);
        }
        else if ( this.getValue() == 1024 ) {
            tileColor = new Color(228, 72, 255, 255);
        }
        else {
            tileColor = new Color( 237, 113, 46, 171);
        }
    }


    /**
     *
     * Gets the color based on setColor()
     *
     * @return tileColor
     */
    public Color getColor()
    {
        this.setColor();
        return tileColor;
    }

}
