import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReader {

	/*
	 * Storage 1 = Used for storing every single answer that each participant
	 * provides in one line | Storage 2 = Used for array indexing and graph Storage
	 * 3 | = Used for logic errors in determining which classes show up | Storage 4
	 * = A duplicate version of Storage 1 but it can be read from the CompareReader
	 * class | Storage 5 = Used for storing percentages to display midway through
	 * survey | Final Results = Used for displaying the final results | 
	 * Feedback Storage = used for storing feedback
	 */

	public FileReader() throws Exception {

		// variables for totaling
		int[] grades = new int[5];
		int[] genders = new int[4];
		int[] level = new int[2];
		int[] activityCount = new int[4];
		int[] science = new int[4];
		int[] fields = new int[10];
		int[] math = new int[4];
		int[] postSec = new int[4];

		PrintWriter writer = null;
		String filename = "Storage2.txt";

		String line = "";
		int number = 0;
		writer = new PrintWriter(new FileWriter(filename));

		Scanner file = new Scanner(new File("Storage.txt"));
		while (file.hasNext()) {

			// grade
			number = file.nextInt();
			if (number == 9) {
				grades[0]++;
			} else if (number == 10) {
				grades[1]++;
			} else if (number == 11) {
				grades[2]++;
			} else if (number == 12) {
				grades[3]++;
			} else {
				grades[4]++;
			}

			// gender
			line = file.next();

			if (line.equals("Male")) {
				genders[0]++;
			} else if (line.equals("Female")) {
				genders[1]++;
			} else if (line.equals("Others")) {
				genders[2]++;
			} else {
				genders[3]++;
			}

			// MST or not
			line = file.next();

			if (line.equals("MST")) {
				level[0]++;
			} else {
				level[1]++;
			}

			// ExtraCurriculars
			line = file.next();

			if (line.equals("0-2")) {
				activityCount[0]++;
			} else if (line.equals("3-5")) {
				activityCount[1]++;
			} else if (line.equals("6-10")) {
				activityCount[2]++;
			} else if (line.equals("11+")) {
				activityCount[3]++;
			}

			// Field Study
			line = file.next();

			if (line.equals("Arts")) {
				fields[0]++;
			} else if (line.equals("Business")) {
				fields[1]++;
			} else if (line.equals("Education")) {
				fields[2]++;
			} else if (line.equals("Engineering")) {
				fields[3]++;
			} else if (line.equals("Computer_Science")) {
				fields[4]++;
			} else if (line.equals("Health_Medicine")) {
				fields[5]++;
			} else if (line.equals("Government")) {
				fields[6]++;
			} else if (line.equals("Law")) {
				fields[7]++;
			} else if (line.equals("Not_sure")) {
				fields[8]++;
			} else if (line.equals("Choice_not_shown")) {
				fields[9]++;
			}

			// Science
			number = file.nextInt();
			for (int i = 0; i < number; i++) {
				line = file.next();
				if (line.equals("Physics")) {
					science[0]++;
				} else if (line.equals("Biology")) {
					science[1]++;
				} else if (line.equals("Chemistry")) {
					science[2]++;
				} else {
					science[3]++;
				}
			}

			// Math
			number = file.nextInt();
			for (int i = 0; i < number; i++) {
				line = file.next();
				if (line.equals("Advanced_Functions")) {
					math[0]++;
				} else if (line.equals("Data_Management")) {
					math[1]++;
				} else if (line.equals("Calculus")) {
					math[2]++;
				} else {
					math[3]++;
				}
			}

			// post secondary
			line = file.next();
			if (line.equals("University")) {
				postSec[0]++;
			} else if (line.equals("College")) {
				postSec[1]++;
			} else if (line.equals("Neither")) {
				postSec[2]++;
			} else {
				postSec[3]++;
			}

		}

		// write all the indexes to the file
		for (int i = 0; i < grades.length; i++) {
			writer.print(grades[i] + " ");
		}
		writer.println();
		for (int i = 0; i < genders.length; i++) {
			writer.print(genders[i] + " ");
		}
		writer.println();
		for (int i = 0; i < level.length; i++) {
			writer.print(level[i] + " ");
		}
		writer.println();
		for (int i = 0; i < activityCount.length; i++) {
			writer.print(activityCount[i] + " ");
		}
		writer.println();
		for (int i = 0; i < fields.length; i++) {
			writer.print(fields[i] + " ");
		}
		writer.println();
		for (int i = 0; i < science.length; i++) {
			writer.print(science[i] + " ");
		}
		writer.println();
		for (int i = 0; i < math.length; i++) {
			writer.print(math[i] + " ");
		}
		writer.println();
		for (int i = 0; i < postSec.length; i++) {
			writer.print(postSec[i] + " ");
		}

		writer.close();

		// allow the duplication of a file so it can be read from elsewhere
		File source = new File("Storage.txt");
		File dest = new File("Storage4.txt");

		copyFileUsingFileStreams(source, dest);

		// call results file class
		new ResultsFile();

	}

	// copy file method
	private static void copyFileUsingFileStreams(File source, File dest)

			throws IOException {

		InputStream input = null;

		OutputStream output = null;

		try {

			input = new FileInputStream(source);

			output = new FileOutputStream(dest);

			byte[] buf = new byte[1024];

			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {

				output.write(buf, 0, bytesRead);

			}

		} finally {

			input.close();
			output.close();

		}

	}

}