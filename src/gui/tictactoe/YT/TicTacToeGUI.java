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

    //main window
    private Container pane;
    
    //Attributes
    private TicTacBoard game;
    
    //menu bar
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    public TicTacToeGUI() 
    {
        //because TTTGUI is a subclass of JFRAME, 
        //we must call the super constructor
        super();
        
        pane = getContentPane();
        
        setSize(1920/2, 1080/2);
        setLocation(1920/4, 1080/4); //center it on screen
        setLayout(new GridLayout(4,3));
        
        
        
        //TODO: ADD SQL OF THE PLAYER NAME?
        game = new TicTacBoard(3,3, pane);
        
        
        
        
        //add 1 empty, then player name j label, then empty
        // EMPT NAME EMPT
        // SLOT SLOT SLOT
        // SLOT SLOT SLOT
        // SLOT SLOT SLOT
        JLabel e1 = new JLabel();
        JLabel e2 = new JLabel("Player: " + game.getPlayerX().getPlayerName() + " (X) Versus Player: " + game.getPlayerO().getPlayerName() + " (O)");
        JLabel e3 = new JLabel();
        
        pane.add(e1);
        pane.add(e2);
        pane.add(e3);
        
        //set attributes
        //setTitle("Tic Tac Toe GUI");
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        
        //setup file
        initializeMenuBar();
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
                //call this func from the gameboard class
                game.resetBoard(); 
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
}
