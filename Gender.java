import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// create public class that creates a JFrame with an ItemListener
public class Gender extends JFrame implements ActionListener, ItemListener {

	// create public gender variable
	public Gender() {

		super("Gender");

		// create JPanel with a GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel question = new JLabel("What is your gender?");
		// create Button with options as shown below
		JRadioButton male = new JRadioButton("Male", false);
		JRadioButton female = new JRadioButton("Female", false);
		JRadioButton other = new JRadioButton("Other", false);
		JRadioButton noSay = new JRadioButton("Prefer not to say", false);
		// create a Button to continue the options
		JButton confirm = new JButton("Continue");

		ButtonGroup genders = new ButtonGroup();
		genders.add(male);
		genders.add(female);
		genders.add(other);
		genders.add(noSay);
		// create progress bar to show how much of survey is complete
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(24);
		progress.setStringPainted(true);
		// create the border of the JFrame with a string at the top of the title and no
		// colour of the border itself
		TitledBorder title;
		Border empty = null;

		panel.setBorder(BorderFactory.createTitledBorder(empty, "GENDER"));
		// initialize the GridBagConstaints layout
		GridBagConstraints gbc = new GridBagConstraints();
		// below is the insets, and the x and y positions of the each component which is
		// added to the panel which is then added to the JFrame
		gbc.insets = new Insets(10, 10, 10, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);

		gbc.insets = new Insets(0, 40, 10, 75);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(male, gbc);

		gbc.insets = new Insets(1, 46, 10, 66);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(female, gbc);

		gbc.insets = new Insets(1, 40, 10, 70);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(other, gbc);

		gbc.insets = new Insets(1, 42, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(noSay, gbc);

		gbc.insets = new Insets(10, 10, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(confirm, gbc);

		gbc.insets = new Insets(10, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(progress, gbc);
// set the countinue button to be false before anything option is chosen from the survey
		confirm.setEnabled(false);

		male.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {
				// for any of the options except for select, the continue button will be enabled
				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}

		});

		female.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}

		});

		other.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}

		});

		noSay.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {

					confirm.setEnabled(true);
				}
			}

		});
		// add actionListener to the continue button
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

				if (male.isSelected()) {

					writer.write("Male ");
				}

				else if (female.isSelected()) {

					writer.write("Female ");
				}

				else if (other.isSelected()) {

					writer.write("Others ");
				}

				else if (noSay.isSelected()) {

					writer.write("Prefer_not_to_say ");
				}
				writer.close();
			}
		});

		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				try {
					new GenderStats();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		// add the panel to the frame, pack the components, set the location to be in
		// the middle of the screen,confirm the visibility,and do not allow the JFrame
		// to be resized
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}