import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

//create public class that creates a JFrame with an ItemListener
public class ExtraCurriculars extends JFrame implements ItemListener {
	
	//create public last variable
	public static Object last;

	public ExtraCurriculars() {
		
		//create super class and add function to close window when "X" is clicked
		super("Extra Curriculars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create JPanel with GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());
		
		//create combobox with options as shown below
		JComboBox numOfEC = new JComboBox();
		numOfEC.addItem("Select");
		numOfEC.addItem("0-2");
		numOfEC.addItem("3-5");
		numOfEC.addItem("6-10");
		numOfEC.addItem("11+");
		
		//create labels that show the question
		JLabel question = new JLabel("How many extra-curricular activities are you currently participating in?");
		JLabel includes = new JLabel("(Extra-Curricluar activities include any clubs, teams etc.)");
		
		//create button to continue to the next window
		JButton confirm = new JButton("Continue");
		
		//create progress bar to show how much of survey is complete
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(48);
		progress.setStringPainted(true);
		
		//create the border of the JFrame with a string at the top of the title and no colour of the border itself
		TitledBorder title;
		Border empty = null;
		panel.setBorder(BorderFactory.createTitledBorder(empty, "EXTRA-CURRICULARS"));		
				
		//initialize the GridBagConstaints layout
		GridBagConstraints gbc = new GridBagConstraints();
		
		//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(20, 20, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);
		
		gbc.insets = new Insets(0, 20, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(includes, gbc);
		
		gbc.insets = new Insets(15, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(numOfEC, gbc);
		
		gbc.insets = new Insets(15, 400, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(confirm, gbc);
		
		gbc.insets = new Insets(5, 360, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(progress, gbc);
		
		//set the continue button to be false before anything option is chosen from the survey
		confirm.setEnabled(false);
		
		//create itemListener for the combobox with shows the options for the number of extra-curricular activities
		numOfEC.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent event) {
				
				//for any of the options except for select, the continue button will be enabled
				if (event.getStateChange() == 1) {
					
					if (event.getItem() == "Select") {
						
						confirm.setEnabled(false);
	
					}
					//the public variable last will the equal to the chosen values for the combobox
					else {
						
						last = event.getItem();
						confirm.setEnabled(true);
					}
				}
			}
		});

		//add actionListener to the continue button
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//initialize printWriter
				
				PrintWriter writer = null;
				String filename = "Storage.txt";
				try {
					writer = new PrintWriter(new FileWriter(filename, true));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//if the select is chosen the continue button will be set to false
				if (last.equals("Select")) {
					
					confirm.setEnabled(false);
				}
				
				//close file and open next window when continue button is clicked
				writer.write(last + " ");
				writer.close();
				new FieldOfStudy();
				dispose();
			}
		});
		
		//add the panel to the frame, pack the components, set the location to be in the 
		//middle of the screen, confirm the visibility, and do not allow the JFrame to be resized
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public void itemStateChanged(ItemEvent e) {
		
	}}