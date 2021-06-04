/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tictactoe.YT;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * This class is an implemented class
 * 3x3 grid. 2D array this.getBoard().
 * 
 * THE INHERITED CLASS IS CALLED "TicTacBoard"
 * 
 * TODO: Refactor win function, add a tie prompt as well...
 * prompt user for new game or exit program on tie/win/loss
 * @author Tarun
 */
public class TicTacBoard extends GameBoard 
{
    //non mentioned attributes...
    
    //Attributes
    private Container pane;
    private GamePlayer currentPlayer; //flipper object
    private GamePlayer playerX;
    private GamePlayer playerO;
    private boolean hasWinner;
    int winnerCalls = 0;
    
    //Storage...
    private StorePlayers sp;
    
    //Constructor
    public TicTacBoard(int r, int c, Container p) 
    {
        super(r, c);
        
        //init human player X
        playerX = new GamePlayer(this.getUserName(), "X");
        
        //init human player O
        playerO = new GamePlayer(this.getUserName(), "O");
        
        //new game
        setCurrentPlayer(playerX);
        setPane(p);
        initBoard();
        
        //SQL
        sp = new StorePlayers();
        sp.createTTToeDB();
    }


    /* Move this to the GameBoard class...
     * Sets up the game board, a 2D array of buttons.
     * All of them come with anon listeners. 
    **/
    @Override
    public void initBoard() 
    {
        winnerCalls = 0;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                JButton buttons = new JButton("EMPTY BUTTON");
                this.getBoard()[i][j] = buttons;
                buttons.addActionListener((ActionEvent ap) -> 
                {
                    if (((JButton) ap.getSource()).getText().equals("EMPTY BUTTON") 
                            && isHasWinner() == false) 
                    {
                        buttons.setText(getCurrentPlayer().getPlayerType());
                        checkForWinner();
                        changeCurrentPlayer();
                    }
                });

                pane.add(buttons);
            }
        }
    }
    
    /*
    * Resets the board, and buttons.
    **/
    public void resetBoard() 
    {
        setCurrentPlayer(getPlayerX());
        hasWinner = false;
        winnerCalls = 0;
        
        for (int i = 0; i < this.getBoard().length; i++) //replace with board.getsize
        {
            for (int j = 0; j < this.getBoard()[i].length; j++) 
            {
                this.getBoard()[i][j].setText("EMPTY BUTTON");
            }
        }
        
        System.out.println("X Matches Played: " + playerX.getMatchesPlayed());        
        System.out.println("X Matches Win: " + playerX.getWins());
        System.out.println("X Matches Lost: " + (playerX.getMatchesPlayed()-playerX.getWins()));
         
        System.out.println("O Matches Played: " + playerO.getMatchesPlayed());        
        System.out.println("O Matches Win: " + playerO.getWins());
        System.out.println("O Matches Lost: " + (playerO.getMatchesPlayed()-playerO.getWins()));
    }
    
    /**
     * Changes the current active player
     */
    private void changeCurrentPlayer() 
    {
        if (getCurrentPlayer().getPlayerType().equalsIgnoreCase("X"))
        {
            setCurrentPlayer(this.getPlayerO());
        } 
        else 
        {
            setCurrentPlayer(this.getPlayerX());
        }
    }
    
    private GamePlayer getOtherPlayer(GamePlayer cp) 
    {
        if (cp.getPlayerType().equalsIgnoreCase("X"))
        {
            return getPlayerO();
        } 
        else 
        {
            return getPlayerX();
        }
    }

    @Override
    public void checkForWinner() 
    {
        //add a statement if nobody won. 
        //increment loss on other player
        winnerCalls++;
        //if else ladder handles X and O win conditions...
        if (this.getBoard()[0][0].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][0].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][0].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[0][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][1].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[0][2].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][2].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][2].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[0][0].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][2].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[0][2].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][0].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[0][0].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[0][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[0][2].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[1][0].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[1][2].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        } 
        else if (this.getBoard()[2][0].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][1].getText().equals(currentPlayer.getPlayerType()) 
                && this.getBoard()[2][2].getText().equals(currentPlayer.getPlayerType())) 
        {
            increaseWins(currentPlayer, this.getOtherPlayer(currentPlayer));
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer.getPlayerName() + " has won");
            setHasWinner(true);
        }
        else if(winnerCalls == 9)
        {
            tie();
            JOptionPane.showMessageDialog(null, "Nobody won...");
            setHasWinner(false);
        }
    }
    
    private void increaseWins(GamePlayer winner, GamePlayer loser)
    {
        winner.incrementWins();
        loser.incrementLoss();
        System.out.println("increaseWins func called.");
    }
    
    private void tie()
    {
        this.getPlayerX().incrementLoss();
        this.getPlayerO().incrementLoss();
        System.out.println("Tie func called.");
    }
    
    public void endGame()
    {
        this.sp.createNewPlayer(playerX);        
        this.sp.createNewPlayer(playerO);
    }
    
    private String getUserName()
    {
        String un = "";
        while(un.equals(""))
        {
            un = JOptionPane.showInputDialog("Player, What's your name?");
        }
        return un;
    }

    /**
     * @return the checkForWinner
     */
    private boolean isHasWinner() {
        return hasWinner;
    }

    /**
     * @param hasWinner the checkForWinner to set
     */
    private void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }

    /**
     * @return the pane
     */
    public Container getPane() {
        return pane;
    }

    /**
     * @param pane the pane to set
     */
    private void setPane(Container pane) {
        this.pane = pane;
    }

    /**
     * @return the currentPlayer
     */
    public GamePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    private void setCurrentPlayer(GamePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * @return the playerX
     */
    public GamePlayer getPlayerX() 
    {
        return playerX;
    }

    /**
     * @param playerX the playerX to set
     */
    private void setPlayerX(GamePlayer playerX) {
        this.playerX = playerX;
    }

    /**
     * @return the playerO
     */
    public GamePlayer getPlayerO() 
    {
        return playerO;
    }

    /**
     * @param playerO the playerO to set
     */
    private void setPlayerO(GamePlayer playerO) 
    {
        this.playerO = playerO;
    }

    /**
     * @return the sp
     */
    public StorePlayers getSp() {
        return sp;
    }

    /**
     * @param sp the sp to set
     */
    public void setSp(StorePlayers sp) {
        this.sp = sp;
    }
}
