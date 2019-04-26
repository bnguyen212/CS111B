import java.util.*;

public class ArrayListTeam {
	
	private String name;
	private int currentPlayerIndex;
	private ArrayList<Player> playerList;
	
	public static final int TEAM_SIZE = 10;
	
	public ArrayListTeam(String initialName, Player ... initialPlayers) {
		// initialPlayers is type Player[]
		// playerList = new ArrayList<Player>(TEAM_SIZE); // only the initial capacity! doesn't set any limits on the size.
		// in general, we only need to set the initial capacity if it's very large and we want to avoid lots of expansion
		
		/* option a for creating my list: */
		/*
		playerList = new ArrayList<Player>();
		if(initialPlayers.length >= TEAM_SIZE) {
			for(int i=0; i<TEAM_SIZE; i++) {
				playerList.add(initialPlayers[i]);
			}
		} else {
			System.out.println("Not enough players. Program exiting.");
			System.exit(1);
		}
		*/
		
		/* option b for creating my list: */
		if(initialPlayers.length == TEAM_SIZE) {
			playerList = new ArrayList<Player>(Arrays.asList(initialPlayers));
		} else {
			System.out.println("Not enough or too many players. Program exiting.");
			System.exit(1);
		}
		name = initialName;
		currentPlayerIndex = 0;
		
	}
	public String getName() {
		return name;
	}
	public ArrayList<Player> getPlayerList() {
		return new ArrayList<>(playerList);
	}
	
	// omitting setters
	
	
	public String toString() {
		String s = name + "\n";
		for(Player player : playerList) {
			s += "\t" + player + "\n";
		}
		return s + "\n";
		
	}
	
	public double averageScore() {
		double total = 0.0;
		for(Player player : playerList) {
			total += player.getHighScore();
		}
		return total / playerList.size();
	
	}
	
	public Player whoseTurn() {
		return playerList.get(currentPlayerIndex);
		
	}
	public void takeATurn() {
		System.out.println(whoseTurn().getName() + " took a turn.");
		currentPlayerIndex = (currentPlayerIndex+1) % playerList.size();
	}
	
	public boolean dropAndReplace(int indexToDrop, Player playerToAdd) {
		if(indexToDrop >= 0 && indexToDrop < playerList.size()) {
			playerList.remove(indexToDrop);
			playerList.add(playerToAdd);
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	

}
