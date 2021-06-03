/*
 * @author Tarun
 * Base program 
 **/
package gui.tictactoe.YT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Tarun
 */
public class TicTacToeGUI extends JFrame {

    private Container pane;
    private String playerName;
    private String currentPlayer;
    private JButton[][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    public TicTacToeGUI() {
        //because TTTGUI is a subclass of JFRAME, 
        //we must call the super constructor
        super();
        
        pane = getContentPane();
        
        setSize(1920/2, 1080/2);
        setLocation(1920/4, 1080/4); //center it on screen
        setLayout(new GridLayout(4,3));
        
        //add 1 empty, then player name j label, then empty
        // EMPT NAME EMPT
        // SLOT SLOT SLOT
        // SLOT SLOT SLOT
        // SLOT SLOT SLOT
        playerName = JOptionPane.showInputDialog("What's your name?");
        setTitle(playerName + "'s Tic Tac Toe Game");
        
        
        JLabel e1 = new JLabel();
        JLabel e2 = new JLabel("Player: " + playerName + " (X) Versus Player: O");
        JLabel e3 = new JLabel();
        
        pane.add(e1);
        pane.add(e2);
        pane.add(e3);
        
        //set attributes
        //setTitle("Tic Tac Toe GUI");
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        //player X goes first
        currentPlayer = "x";
        board = new JButton[3][3];
        hasWinner = false;
        
        initializeMenuBar();
        initializeBoard();
        
    }
    


    /*
     * Sets up our menu bar. 
    **/
    private void initializeMenuBar() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        
        //New Game Menu Item
        newGame = new JMenuItem("New Game");

        //Anonymous AL class
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });
        
        //Quit Button Item
        quit = new JMenuItem("Quit Game");

        //Anonymous AL class
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    
    /*
     * Sets up the game board, a 2D array of buttons.
     * All of them come with anon listeners. 
    **/
    private void initializeBoard() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                JButton buttons = new JButton("EMPTY BUTTON");
                board[i][j] = buttons;
                buttons.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        if (((JButton) e.getSource()).getText().equals("EMPTY BUTTON") && hasWinner == false) {
                            buttons.setText(currentPlayer);
                            hasWinner();
                            togglePlayer();
                        }
                    }
                });

                pane.add(buttons);
            }
        }
    }
    
    /*
    * Move this to the GameBoard class...
    **/
    private void resetBoard() 
    {
        currentPlayer = "x";
        hasWinner = false;
        
        for (int i = 0; i < board.length; i++) //replace with board.getsize
        {
            for (int j = 0; j < board[i].length; j++) 
            {
                board[i][j].setText("EMPTY BUTTON");
            }
        }
    }

    private void togglePlayer() {
        if (currentPlayer.equals("x")) 
        {
            currentPlayer = "o";
        } 
        else 
        {
            currentPlayer = "x";
        }
    }
    
    /*
    * Move this to the GameBoard class...
    **/
    private void hasWinner() {
        if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won");
            hasWinner = true;
        } 
        else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        } 
        else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        } 
        else if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        } 
        else if (board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        } 
        else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        } 
        else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        } 
        else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) 
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }
    }
}
