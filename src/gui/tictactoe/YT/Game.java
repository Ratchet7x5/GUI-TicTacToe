/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tictactoe.YT;

import javax.swing.SwingUtilities;

/**
 *
 * @author Tarun
 */
public class Game 
{
    public static void main(String[] args)
    {
        //run the game thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}
