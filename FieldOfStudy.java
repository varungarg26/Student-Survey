import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

// create public class that creates a JFrame with an ItemListener
public class FieldOfStudy extends JFrame implements ActionListener, ItemListener {
//create public lst variable
	public static Object last;

	public FieldOfStudy() {
		// create super field and add function to close window when "X" is clicked
		super("Field Of Study");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//create JPanel with GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel question = new JLabel("What field of study interests you THE MOST?");
		JLabel checkone = new JLabel("(CHOOSE ONE)");
// create checkbox with options as shown below
		JCheckBox arts = new JCheckBox("Arts", false);
		JCheckBox business = new JCheckBox("Business", false);
		JCheckBox education = new JCheckBox("Education", false);
		JCheckBox engineering = new JCheckBox("Engineering", false);
		JCheckBox compsci = new JCheckBox("Computer Science", false);
		JCheckBox govern = new JCheckBox("Government", false);
		JCheckBox healthmed = new JCheckBox("Health & Medicine", false);
		JCheckBox law = new JCheckBox("Law", false);
		JCheckBox unsure = new JCheckBox("Not sure", false);
		JCheckBox notshown = new JCheckBox("My choice is not shown", false);

		ButtonGroup careers = new ButtonGroup();
		careers.add(notshown);
		careers.add(business);
		careers.add(arts);
		careers.add(education);
		careers.add(engineering);
		careers.add(compsci);
		careers.add(govern);
		careers.add(healthmed);
		careers.add(law);
		careers.add(unsure);
// create a button to continue to the next window
		JButton confirm = new JButton("Continue");

		GridBagConstraints gbc = new GridBagConstraints();
//create progress bar to show how much of survey is complete
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(60);
		progress.setStringPainted(true);
		// create the border of the JFrame with a string at the top of the title and no
		// colour of the border itself
		TitledBorder title;
		Border empty = null;

		panel.setBorder(BorderFactory.createTitledBorder(empty, "FIELD OF STUDY"));
//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(5, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);

		gbc.insets = new Insets(40, 0, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(checkone, gbc);

		gbc.insets = new Insets(0, 0, 10, 220);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(arts, gbc);

		gbc.insets = new Insets(0, 15, 10, 206);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(business, gbc);

		gbc.insets = new Insets(0, 15, 10, 202);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(education, gbc);

		gbc.insets = new Insets(0, 15, 10, 192);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(engineering, gbc);

		gbc.insets = new Insets(0, 15, 10, 154);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(compsci, gbc);

		gbc.insets = new Insets(0, 200, 10, 50);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(healthmed, gbc);

		gbc.insets = new Insets(0, 200, 10, 80);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(govern, gbc);

		gbc.insets = new Insets(0, 200, 10, 124);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(law, gbc);

		gbc.insets = new Insets(0, 200, 10, 100);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(unsure, gbc);

		gbc.insets = new Insets(0, 200, 10, 13);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(notshown, gbc);

		gbc.insets = new Insets(10, 290, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(confirm, gbc);

		gbc.insets = new Insets(10, 5, 5, 200);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(progress, gbc);

		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
//set the continue button to be false before anything option is chosen from the survey
		confirm.setEnabled(false);

		arts.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		business.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		education.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		engineering.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		compsci.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		govern.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		healthmed.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		law.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		unsure.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});

		notshown.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}
		});
//add actionListener to the continue buttion
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				// initialize printWriter
				PrintWriter writer = null;

				String filename = "Storage.txt";

				try {

					writer = new PrintWriter(new FileWriter(filename, true));

				} catch (IOException e) {

					e.printStackTrace();
				}

				if (arts.isSelected()) {

					last = "Arts";
				}

				else if (business.isSelected()) {

					last = "Business";
				}

				else if (education.isSelected()) {

					last = "Education";
				}

				else if (engineering.isSelected()) {

					last = "Engineering";
				}

				else if (compsci.isSelected()) {

					last = "Computer_Science";
				}

				else if (healthmed.isSelected()) {

					last = "Health_Medicine";
				}

				else if (govern.isSelected()) {

					last = "Government";
				}

				else if (law.isSelected()) {

					last = "Law";
				}

				else if (unsure.isSelected()) {

					last = "Not_sure";
				}

				else if (notshown.isSelected()) {

					last = "Choice_not_shown";
				}

				writer.write(last + " ");

				try {
					Scanner file = new Scanner(new File("Storage3.txt"));
					if (file.nextInt() == 2) {
						new Science();
					} else if (file.nextInt() == 1) {

						new Science();
					} else {
						writer.write("1 None 1 None ");
						new PostSecondary();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				writer.close();

				dispose();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}
}
