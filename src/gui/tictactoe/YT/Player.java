package gui.tictactoe.YT;

/**
 * Abstract Class to represent a player name. 
 * Inherited class is "GamePlayer"
 * @author Tarun
 */
public abstract class Player 
{
    private String playerName;
    private String playerType;
    
    Player(String name, String type)
    {
        setPlayerName(name);
        setPlayerType(type.toUpperCase()); //we want the types to be upper case
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() 
    {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    private void setPlayerName(String playerName) 
    {
        this.playerName = playerName;
    }

    /**
     * @return the playerType
     */
    public String getPlayerType() 
    {
        return playerType;
    }

    /**
     * @param playerType the playerType to set
     */
    private void setPlayerType(String playerType) 
    {
        this.playerType = playerType;
    }
}
