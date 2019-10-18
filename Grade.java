import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

//create public class that creates a JFrame with an ItemListener
public class Grade extends JFrame implements ItemListener, ActionListener {
//create public last variable
	public static Object last;

	public Grade() {
// create super grade and add function to close window when "X" is click
		super("Grade");

		FileWriter hsdj;
		JPanel panel = new JPanel(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("What is your grade?");
//create a combobox with options as shown below
		JComboBox grades = new JComboBox();
		grades.addItem("Select");
		grades.addItem("9");
		grades.addItem("10");
		grades.addItem("11");
		grades.addItem("12");
		grades.addItem("Other");
//create button to continue to the next window
		JButton confirm = new JButton("Continue");

		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(12);
		progress.setStringPainted(true);
		// create the border of the JFrame with a string at the top of the title and no
		// colour of the border itself
		TitledBorder title;
		Border empty = null;

		panel.setBorder(BorderFactory.createTitledBorder(empty, "GRADE"));
//initialize the GridBagConstaints layout
		GridBagConstraints gbc = new GridBagConstraints();
//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(10, 20, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(label, gbc);

		gbc.insets = new Insets(10, 10, 10, 20);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(grades, gbc);

		gbc.insets = new Insets(10, 10, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(confirm, gbc);

		gbc.insets = new Insets(10, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(progress, gbc);
//set the continue button to be false before anything option is chosen from the survey
		confirm.setEnabled(false);

		grades.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == 1) {
					if (event.getItem() == "Select") {
						confirm.setEnabled(false);
					} else {
						confirm.setEnabled(true);
						if (event.getItem() == "Other") {
							last = 0;
						} else {
							last = event.getItem();
						}
					}
				}
//for any of the options except for select, the continue button will be enabled
				if (event.getStateChange() == 0) {

					confirm.setEnabled(false);
				}
			}
		});
//add actionListener to the continue button
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				confirm.setBackground(Color.RED);
				// initialize printWriter
				PrintWriter writer = null;
				PrintWriter writer2 = null;
				String filename = "Storage.txt";
				String filename2 = "Storage3.txt";
				try {
					writer = new PrintWriter(new FileWriter(filename, true));
					writer2 = new PrintWriter(new FileWriter(filename2));
				} catch (IOException e) {
					e.printStackTrace();
				}
				// close file and open next window when continue button is clicked
				writer.write(last + " ");
				writer.close();

				if (last == "9" || last == "10" || last == "Other") {
					writer2.print("0 0 ");
				} else if (last == "11") {
					writer2.print("1 1 ");
				} else {
					writer2.print("2 2 ");
				}

				writer2.close();
				try {
					new GradeStats();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
//add the panel to the frame, pack the components, set the location to be in the middle of the screen, confirm the visibility, and do not allow the JFrame to be resized
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new Grade();
	}

	public void itemStateChanged(ItemEvent e) {

	}

	public void actionPerformed(ActionEvent arg0) {

	}

}