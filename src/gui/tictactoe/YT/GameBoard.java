/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tictactoe.YT;

import javax.swing.*;

/**
 * This class is a master class
 * you can make a 2D array
 * 3x3 grid is standard
 * users can also use a 4x4 grid if they wish. 
 * 
 * 
 * 
 * THE INHERITED CLASS IS CALLED "TicTacBoard"
 * @author Tarun
 */
public abstract class GameBoard 
{
    private JButton[][] board;
    
    //we do not want this to be tampered 
    //with outside of this class
    protected int nRows;
    protected int nCols;
    
    //replace this later, with Player
    private String currentPlayer;
    
    GameBoard(int r, int c)
    {
        this.setnRows(r);
        this.setnCols(c);
        
        board = new JButton[this.getnRows()][this.getnCols()];
    }
    
    //Important Mutator funcs
    //=========================================
    
    public abstract void checkForWinner();
    public abstract void initBoard(); //add buttons
    //public abstract void resetBoard();
    
    //Getters and Setters
    //==========================================

    /**
     * @return the board
     */
    public JButton[][] getBoard() 
    {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(JButton[][] board) 
    {
        this.board = board;
    }

    /**
     * @return the nRows
     */
    private int getnRows() {
        return nRows;
    }

    /**
     * Method should only be accessible within this class
     * @param nRows the nRows to set
     */
    private void setnRows(int nRows) {
        this.nRows = nRows;
    }

    /**
     * Method should only be accessible within this class
     * @return the nCols
     */
    private int getnCols() {
        return nCols;
    }

    /**
     * Method should only be accessible within this class
     * @param nCols the nCols to set
     */
    private void setnCols(int nCols) {
        this.nCols = nCols;
    }

    /**
     * @return the hasWinner
     */
}
