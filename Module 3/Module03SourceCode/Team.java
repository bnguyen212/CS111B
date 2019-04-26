import java.util.Arrays;

public class Team {
	
	private String name;
	private Player[] players;
	private int currentPlayerIndex;
	
	public static final int TEAM_SIZE = 10;
	
	public Team(String initialName, Player ... initialPlayers) {
		 // initialPlayers is type Player[]
		players = new Player[TEAM_SIZE];
		if(initialPlayers.length>=TEAM_SIZE) { // could also set to be ==
			for(int i=0; i<TEAM_SIZE; i++) {
				players[i] = initialPlayers[i];
			}
		} else {
			System.out.println("Not enough players sent! Program exiting."); // in reality: we should throw an exception (we'll learn how eventually!)
			System.exit(1);
		}
		name = initialName;
		currentPlayerIndex = 0;
	}
	public String getName() {
		return name;
	}
	public Player[] getPlayers() {
		return Arrays.copyOf(players, players.length);
	}
	
	// omitting all setters
	
	public String toString() {
		String s = name + "\n";
		for(Player player : players) {
			s += "\t" + player + "\n";
		}
		s += "\n";
		return s;
	}
	
	public double averageScore() {
		double total = 0;
		for(Player player : players) {
			total += player.getHighScore();
		}
		return total / players.length;
	}
	
	public Player whoseTurn() {
		return players[currentPlayerIndex];
	}
	public void takeATurn() {
		System.out.println(whoseTurn().getName() + " took a turn.");
		// currentPlayerIndex++; this will go out of bounds eventually!
		currentPlayerIndex = (currentPlayerIndex+1) % players.length;
	}
	
	
	
	
	
	

}
