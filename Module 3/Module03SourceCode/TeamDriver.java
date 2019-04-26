
public class TeamDriver {

	public static void main(String[] args) {
		Player p1 = new Player("PlayerA", 11, 43.5);
		Player p2 = new Player("PlayerB", 22, 12);
		Player p3 = new Player("PlayerC", 33, 72.8);
		Player p4 = new Player("PlayerD", 44, 64);
		Player p5 = new Player("PlayerE", 55, 92);
		Player p6 = new Player("PlayerF", 66, 18.7);
		Player p7 = new Player("PlayerG", 77, 17.3);
		Player p8 = new Player("PlayerH", 88, 41.7);
		Player p9 = new Player("PlayerI", 99, 39);
		Player p10 = new Player("PlayerJ", 00, 40);
		
		//Team team = new Team("Team Players", p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
		ArrayListTeam team = new ArrayListTeam("Team Players", p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
		System.out.println(team);

		/*
		Player[] playerHackerArray = team.getPlayers(); // playersHackerArray and team.players are aliases- they point to the same place in memory!
		playerHackerArray[5] = null;
		System.out.println(team);
		playerHackerArray[9].setName("NO NAME");
		System.out.println(team);
		*/
		
		System.out.println("Team average is " + team.averageScore());
		System.out.println("Whose turn? " + team.whoseTurn().getName());
		team.takeATurn();
		System.out.println("Whose turn? " + team.whoseTurn().getName());
		for(int i=0; i<20; i++) {
			System.out.println("Whose turn? " + team.whoseTurn().getName());
			team.takeATurn();
		}
		
		System.out.println(team);
		Player newPlayer = new Player("PlayerK", 13, 13);
		boolean success = team.dropAndReplace(-1, newPlayer);
		System.out.println("Success? " + success);
		System.out.println(team);
		team.dropAndReplace(14, newPlayer);
		System.out.println(team);
	}

}
