import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ResultsFile {

	public ResultsFile() throws IOException {

		// store the values
		int[] grades = new int[5];
		int[] genders = new int[4];
		int[] level = new int[2];
		int[] activityCount = new int[4];
		int[] science = new int[4];
		int[] fields = new int[10];
		int[] math = new int[4];
		int[] postSec = new int[4];

		// initialize sums and percentage arrays
		int gradeSum = 0;
		int genderSum = 0;
		int levelSum = 0;
		int activitySum = 0;
		int fieldSum = 0;
		int scienceSum = 0;
		int mathSum = 0;
		int postSecSum = 0;
		double[] gradePercent = new double[5];
		double[] genderPercent = new double[4];
		double[] levelPercent = new double[2];
		double[] activitiesPercent = new double[4];
		double[] fieldPercent = new double[10];
		double[] sciencePercent = new double[4];
		double[] mathPercent = new double[4];
		double[] postSecPercent = new double[4];

		DecimalFormat df = new DecimalFormat("#.##");
		// read and write entire results file
		PrintWriter writer = null;
		PrintWriter writer2 = null;
		String filename = "Final Results.txt";
		String filename2 = "Storage5.txt";

		Scanner file = new Scanner(new File("Storage2.txt"));
		writer = new PrintWriter(new FileWriter(filename));
		writer2 = new PrintWriter(new FileWriter(filename2));

		// assign a value for each index, calculate sum and calculate percentages
		// grades
		for (int i = 0; i < grades.length; i++) {
			grades[i] = file.nextInt();
			gradeSum = gradeSum + grades[i];
		}
		for (int i = 0; i < gradePercent.length; i++) {
			gradePercent[i] = (double) grades[i] * 100 / gradeSum;
		}

		// gender
		for (int i = 0; i < genders.length; i++) {
			genders[i] = file.nextInt();
			genderSum = genderSum + genders[i];
		}
		for (int i = 0; i < genderPercent.length; i++) {
			genderPercent[i] = (double) genders[i] * 100 / genderSum;
		}

		// level
		for (int i = 0; i < level.length; i++) {
			level[i] = file.nextInt();
			levelSum = levelSum + level[i];
		}
		for (int i = 0; i < levelPercent.length; i++) {
			levelPercent[i] = (double) level[i] * 100 / levelSum;
		}

		// activities
		for (int i = 0; i < activityCount.length; i++) {
			activityCount[i] = file.nextInt();
			activitySum = activitySum + activityCount[i];
		}
		for (int i = 0; i < activitiesPercent.length; i++) {
			activitiesPercent[i] = (double) activityCount[i] * 100 / activitySum;
		}

		// fields
		for (int i = 0; i < fields.length; i++) {
			fields[i] = file.nextInt();
			fieldSum = fieldSum + fields[i];
		}
		for (int i = 0; i < fieldPercent.length; i++) {
			fieldPercent[i] = (double) fields[i] * 100 / fieldSum;
		}

		// sciences
		for (int i = 0; i < science.length; i++) {
			science[i] = file.nextInt();
			scienceSum = scienceSum + science[i];
		}
		for (int i = 0; i < sciencePercent.length; i++) {
			sciencePercent[i] = (double) science[i] * 100 / scienceSum;
		}

		// maths
		for (int i = 0; i < math.length; i++) {
			math[i] = file.nextInt();
			mathSum = mathSum + math[i];
		}
		for (int i = 0; i < mathPercent.length; i++) {
			mathPercent[i] = (double) math[i] * 100 / mathSum;
		}

		// post-secondary
		for (int i = 0; i < postSec.length; i++) {
			postSec[i] = file.nextInt();
			postSecSum = postSecSum + postSec[i];
		}
		for (int i = 0; i < postSecPercent.length; i++) {
			postSecPercent[i] = (double) postSec[i] * 100 / postSecSum;
		}

		writer.println("Main file that shows all the totals for every category.");
		writer.println("Percentages show that specific option in relation to the total for that category.");
		writer.println();

		// grades
		writer.println("Grades");
		writer.println(grades[0] + " participant(s) are in Grade 9.   (" + df.format(gradePercent[0]) + "%)");
		writer.println(grades[1] + " participant(s) are in Grade 10.   (" + df.format(gradePercent[1]) + "%)");
		writer.println(grades[2] + " participant(s) are in Grade 11.   (" + df.format(gradePercent[2]) + "%)");
		writer.println(grades[3] + " participant(s) are in Grade 12.   (" + df.format(gradePercent[3]) + "%)");
		writer.println(grades[4] + " participant(s) are in Grade Other.   (" + df.format(gradePercent[4]) + "%)");
		writer.println();

		// gender
		writer.println("Genders");
		writer.println(genders[0] + " participant(s) are Male.   (" + df.format(genderPercent[0]) + "%)");
		writer.println(genders[1] + " participant(s) are Female.   (" + df.format(genderPercent[1]) + "%)");
		writer.println(genders[2] + " participant(s) are Other.   (" + df.format(genderPercent[2]) + "%)");
		writer.println(genders[3] + " participant(s) chose not to say.   (" + df.format(genderPercent[3]) + "%)");
		writer.println();

		// class
		writer.println("Classes");
		writer.println(level[0] + " participant(s) are in MST.   (" + df.format(levelPercent[0]) + "%)");
		writer.println(level[1] + " participant(s) are not in MST.   (" + df.format(levelPercent[1]) + "%)");
		writer.println();

		// extracurriculars
		writer.println("Extracurriculars");
		writer.println(activityCount[0] + " participant(s) have 0-2 extracurricular activities.   ("
				+ df.format(activitiesPercent[0]) + "%)");
		writer.println(activityCount[1] + " participant(s) have 3-5 extracurricular activities.   ("
				+ df.format(activitiesPercent[1]) + "%)");
		writer.println(activityCount[2] + " participant(s) have 6-10 extracurricular activities.   ("
				+ df.format(activitiesPercent[2]) + "%)");
		writer.println(activityCount[3] + " participant(s) have 11+ extracurricular activities.   ("
				+ df.format(activitiesPercent[3]) + "%)");
		writer.println();

		// field of study
		writer.println("Field of Studies");
		writer.println(fields[0] + " participant(s) chose Arts as their main field of study.   ("
				+ df.format(fieldPercent[0]) + "%)");
		writer.println(fields[1] + " participant(s) chose Business as their main field of study.   ("
				+ df.format(fieldPercent[1]) + "%)");
		writer.println(fields[2] + " participant(s) chose Education as their main field of study.   ("
				+ df.format(fieldPercent[2]) + "%)");
		writer.println(fields[3] + " participant(s) chose Engineering as their main field of study.   ("
				+ df.format(fieldPercent[3]) + "%)");
		writer.println(fields[4] + " participant(s) chose Computer Science as their main field of study.   ("
				+ df.format(fieldPercent[4]) + "%)");
		writer.println(fields[5] + " participant(s) chose Health Medicine as their main field of study.   ("
				+ df.format(fieldPercent[5]) + "%)");
		writer.println(fields[6] + " participant(s) chose Government as their main field of study.   ("
				+ df.format(fieldPercent[6]) + "%)");
		writer.println(fields[7] + " participant(s) chose Law as their main field of study.   ("
				+ df.format(fieldPercent[7]) + "%)");
		writer.println(fields[8] + " participant(s) are Not Sure what their main field of study is.   ("
				+ df.format(fieldPercent[8]) + "%)");
		writer.println(fields[9] + " participant(s) chose a field that was not shown.   (" + df.format(fieldPercent[9])
				+ "%)");
		writer.println();

		// sciences
		writer.println("Sciences");
		writer.println(science[0] + " participant(s) are taking/in Physics.   (" + df.format(sciencePercent[0]) + "%)");
		writer.println(science[1] + " participant(s) are taking/in Biology.   (" + df.format(sciencePercent[1]) + "%)");
		writer.println(
				science[2] + " participant(s) are taking/in Chemistry.   (" + df.format(sciencePercent[2]) + "%)");
		writer.println(science[3] + " participant(s) are not taking any extra sciences.   ("
				+ df.format(sciencePercent[3]) + "%)");
		writer.println();

		// maths
		writer.println("Maths");
		writer.println(
				math[0] + " participant(s) are taking/in Advanced Functions.   (" + df.format(mathPercent[0]) + "%)");
		writer.println(
				math[1] + " participant(s) are taking/in Data Management.   (" + df.format(mathPercent[1]) + "%)");
		writer.println(math[2] + " participant(s) are taking/in Calculus.   (" + df.format(mathPercent[2]) + "%)");
		writer.println(math[3] + " participant(s) are not taking any extra mathematics.   (" + df.format(mathPercent[3])
				+ "%)");
		writer.println();

		// post secondary
		writer.println("Post-Secondary Educations");
		writer.println(postSec[0] + " participant(s) are planning to pursue University education.   ("
				+ df.format(postSecPercent[0]) + "%)");
		writer.println(postSec[1] + " participant(s) are planning to pursue College education.   ("
				+ df.format(postSecPercent[1]) + "%)");
		writer.println(postSec[2] + " participant(s) aren't planning to pursue any post-secondary education.   ("
				+ df.format(postSecPercent[2]) + "%)");
		writer.println(postSec[3] + " participant(s) are not sure about post-secondary education.   ("
				+ df.format(postSecPercent[3]) + "%)");
		writer.println();

		writer.close();
		new CompareReader();

		// Writing to another file
		writer2.println(df.format(gradePercent[0]) + " " + df.format(gradePercent[1]) + " " + df.format(gradePercent[2])
				+ " " + df.format(gradePercent[3]) + " " + df.format(gradePercent[4]));
		writer2.println(df.format(genderPercent[0]) + " " + df.format(genderPercent[1]) + " "
				+ df.format(genderPercent[2]) + " " + df.format(genderPercent[3]));
		writer2.println(df.format(levelPercent[0]) + " " + df.format(levelPercent[1]));
		writer2.println(df.format(postSecPercent[0]) + " " + df.format(postSecPercent[1]) + " "
				+ df.format(postSecPercent[2]) + " " + df.format(postSecPercent[3]));
		writer2.close();


	}

}
