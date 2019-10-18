import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CompareReader {
	
	public CompareReader() throws IOException {
		
		//initialize print writer
		PrintWriter writer = null;
		String filename = "Final Results.txt";
		
		//initialize variables for operations
		int nineMST = 0;
		int nineMSTUni = 0;
		double nineMSTPercentage = 0;
		int maleMST = 0;
		double maleMSTPercentage = 0;
		int femaleMST = 0;
		double femaleMSTPercentage = 0;
		int otherMST = 0;
		double otherMSTPercentage = 0;
		int totalMST = 0;
		int engineerMST = 0;
		double engineerMSTPercentage = 0;
		int compMST = 0;
		double compMSTPercentage = 0;
		int healthMST = 0;
		double healthMSTPercentage = 0;
		int total12 = 0;
		int total12Post = 0;
		double twelvePostPercentage = 0;
		int physicsCount = 0;
		double physicsMSTPercentage = 0;
		
		Scanner file = new Scanner(new File("Storage4.txt"));
		writer = new PrintWriter(new FileWriter(filename, true));
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		//loop every line in the storage file
		while (file.hasNextLine()) {
	        String line = file.nextLine();
	        if(line.contains("9") && line.contains("MST") && line.contains("University")) { 
	            nineMSTUni++;
	        }
	        
	        if (line.contains("9") && line.contains("MST")){
	        	nineMST++;
	        }
	        
	        if (line.contains("Male") && line.contains("MST")) {
	        	maleMST++;
	        }
	        
	        if (line.contains("Female") && line.contains("MST")) {
	        	femaleMST++;
	        }
	        
	        if (line.contains("Others") || line.contains("Prefer_not_to_say") && line.contains("MST")) {
	        	otherMST++;
	        }
	        
	        if (line.contains("MST")) {
	        	totalMST++;
	        }
	        
	        if (line.contains("MST") && line.contains("Engineering")) {
	        	engineerMST++;
	        }
	        
	        if (line.contains("MST") && line.contains("Computer_Science")) {
	        	compMST++;
	        }
	        
	        if (line.contains("MST") && line.contains("Health_Medicine")) {
	        	healthMST++;
	        }
	        
	        if ((line.contains("12") && line.contains("University")) || (line.contains("12") && line.contains("College"))) {
	        	total12Post++;
	        }
	        
	        if (line.contains("12")) {
	        	total12++;
	        }
	        
	        if (line.contains("MST") && line.contains("Physics")) {
	        	physicsCount++;
	        }
	    }
		
		
		//calculations
		nineMSTPercentage = (double) nineMSTUni * 100 / nineMST;
		maleMSTPercentage = (double) maleMST * 100 / totalMST;
		femaleMSTPercentage = (double) femaleMST * 100 / totalMST;
		otherMSTPercentage = (double) otherMST * 100 / totalMST;
		engineerMSTPercentage = (double) engineerMST * 100 / totalMST;
		compMSTPercentage = (double) compMST * 100 / totalMST;
		healthMSTPercentage = (double) healthMST * 100 / totalMST;
		twelvePostPercentage = (double) total12Post * 100 / total12;
		physicsMSTPercentage = (double) physicsCount * 100 / totalMST;
		
		// note for the reader
		writer.println("Below are the comparisons between answers per person.");
		writer.println();
		
		//9 MST Uni vs. 9 MST only
		writer.println("Comparison between Grade 9 MSTs in whether they already want to pursue University.");
		writer.println(df.format(nineMSTPercentage) + "% of Grade 9 MSTs already decided to pursue University compared to all Grade 9 MSTs.");
		writer.println();
		
		//male to female
		writer.println("Comparison between the amount of male and female MSTs.");
		writer.println("Out of " + totalMST + " MST students: ");
		writer.println(df.format(maleMSTPercentage) + "% are male MSTs.");
		writer.println(df.format(femaleMSTPercentage) + "% are female MSTs.");
		writer.println(df.format(otherMSTPercentage) + "% are others.");
		writer.println();
		
		//all of MST vs. specific fields of study
		writer.println("Comparison between 3 specific post-secondary fields and all of MST.");
		writer.println("Out of " + totalMST + " MST students: ");
		writer.println(df.format(engineerMSTPercentage) + "% are in MST and want to pursue Engineering.");
		writer.println(df.format(compMSTPercentage) + "% are in MST and want to pursue Computer Science.");
		writer.println(df.format(healthMSTPercentage) + "% are in MST and want to pursue Health & Medicines.");
		writer.println();
		
		//total 12 vs. 12 pursuing post-secondary
		writer.println("Comparison between the amount of Grade 12s pursuing post-secondary or not.");
		writer.println("Out of " + total12 + " Grade 12 students: ");
		writer.println(df.format(twelvePostPercentage) + "% will pursue post-secondary education.");
		writer.println();
		
		//MST with physics vs. MST without physics
		writer.println("Comparison between MST students that take Physics compared to those without Physics.");
		writer.println("Out of " + totalMST + " MST students: ");
		writer.println(df.format(physicsMSTPercentage) + "% of MST students take Physics.");
		
		writer.close();
		
	}
}
