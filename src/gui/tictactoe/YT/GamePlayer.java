/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.tictactoe.YT;


public class GamePlayer extends Player 
{
    private int wins = 0;
    private int matchesPlayed = 0;
    
    public GamePlayer(String n, String t) 
    {
        super(n, t);
        setWins(0);
        setMatchesPlayed(0);
    }
    
    public void incrementWins()
    {
        wins++;
        matchesPlayed++;
    }
    
    public void incrementLoss()
    {
        matchesPlayed+=1;
    }

    /**
     * @return the wins
     */
    public int getWins() 
    {
        return wins;
    }

    /**
     * @param wins the wins to set
     */
    private void setWins(int wins) 
    {
        this.wins = wins;
    }

    /**
     * @return the matchesPlayed
     */
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    /**
     * @param matchesPlayed the matchesPlayed to set
     */
    private void setMatchesPlayed(int matchesPlayed) 
    {
        this.matchesPlayed = matchesPlayed;
    }
}
