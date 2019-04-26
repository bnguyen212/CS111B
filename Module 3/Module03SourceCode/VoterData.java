import java.util.*;

public class VoterData {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("How many candidates?");
		int numCandidates = Integer.parseInt(scan.nextLine());
		System.out.println("How many districts?");
		int numDistricts = Integer.parseInt(scan.nextLine());
		
		int[][] voterData = new int[numCandidates][numDistricts];

		// nested loop will allow us to fill up every cell in the matrix
		for(int i=0; i<numCandidates; i++) { // go through each row; could use voterData.length instead of numCandidates
			for(int j=0; j<numDistricts; j++) { // go through each column; could use voterData[i].length instead of numDistricts
				System.out.println("How many votes did candidate " + i + " get in district " + j + "?");
				int numVotes = Integer.parseInt(scan.nextLine());
				voterData[i][j] = numVotes;			
			}
		}

		
		// print the matrix
		// label the columns
		System.out.print("\t");
		for(int i=0; i<numDistricts; i++) { // could use voterData[i].length instead of numDistricts
			System.out.print("D" + i + "\t");
		}
		System.out.println();
		for(int i=0; i<numCandidates; i++) { // could use voterData.length instead of numCandidates
			System.out.print("C" + i + "\t");
			for(int j=0; j<numDistricts; j++) { // could use voterData[i].length instead of numDistricts
				System.out.print(voterData[i][j] + "\t");
			}
			System.out.println();
		}
		
		// calculate the total of votes for each candidate
		for(int i=0; i<numCandidates; i++) { // could use voterData.length instead of numCandidates
			int total = 0;
			System.out.println("Candidate " + i + " voter data: " + Arrays.toString(voterData[i])); // voterData[i] is an int[]
			for(int j=0; j<numDistricts; j++) { // could use voterData[i].length instead of numDistricts
				total += voterData[i][j];
			}
			System.out.println("Candidate " + i + " got " + total + " votes.");
		}
		
		// calculate the total votes made in each district
		for(int i=0; i<numDistricts; i++) { 
			int total = 0;
			for(int j=0; j<numCandidates; j++) { // could use voterData.length instead of numCandidates
				total += voterData[j][i];
			}
			System.out.println("In District " + i + " there were " + total + " votes made.");
		}
	
	
	
	
	}

}
