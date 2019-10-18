import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//create public class that creates a JFrame with an ActionListener
public class Math extends JFrame implements ActionListener {

	//create public variables
	public static Object last = "";
	public static int mathCount = 0;
	
	public Math() {
		
		//create super class and add function to close window when "X" is clicked
		super("Math");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create JPanel with GridBagLayout
		JPanel panel = new JPanel(new GridBagLayout());
		
		//create checkboxes 
		JCheckBox functions = new JCheckBox("Advanced Functions", false);
		JCheckBox data = new JCheckBox("Data Management", false);
		JCheckBox calculus = new JCheckBox("Calculus", false);
		JCheckBox none = new JCheckBox("None", false);
		
		//create labels for question
		JLabel question = new JLabel("Are you taking Math?");
		JLabel checkall = new JLabel("(Check all that apply)");
		
		//create button to continue to the next window
		JButton confirm = new JButton("Continue");
		
		//create progress bar to show how much of survey is complete
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setValue(84);
		progress.setStringPainted(true);
		
		//create the border of the JFrame with a string at the top of the title and no colour of the border itself
		TitledBorder title;
		Border empty = null;
				
		panel.setBorder(BorderFactory.createTitledBorder(empty, "Math"));
		
		//initialize the GridBagConstaints layout
		GridBagConstraints gbc = new GridBagConstraints();
		
		//below is the insets, and the x and y positions of the each component which is added to the panel which is then added to the JFrame
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(question, gbc);
		
		gbc.insets = new Insets(30, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(checkall, gbc);
		
		gbc.insets = new Insets(0, 40, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(functions, gbc);
		
		gbc.insets = new Insets(0, 34, 10, 14);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(data, gbc);
		
		gbc.insets = new Insets(0, 20, 10, 53);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(calculus, gbc);
		
		gbc.insets = new Insets(0, 7, 10, 58);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(none, gbc);
		
		gbc.insets = new Insets(10, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(confirm, gbc);
		
		gbc.insets = new Insets(10, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(progress, gbc);
		
		//add the panel to the frame, pack the components, set the location to be in the 
		//middle of the screen, confirm the visibility, and do not allow the JFrame to be resized
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		//set the continue button to be false before anything option is chosen from the survey
		confirm.setEnabled(false);
		
		//create itemListener for each of the checkboxes according to how they are checked and how many of the other checkboxes are checked
		none.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					functions.setSelected(false);
					data.setSelected(false);
					calculus.setSelected(false);
					
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if (event.getStateChange() == ItemEvent.SELECTED && !(data.isSelected() && calculus.isSelected() && functions.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (data.isSelected() || calculus.isSelected() || functions.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		});
		
		functions.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					none.setSelected(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if ((event.getStateChange() == ItemEvent.DESELECTED) && (data.isSelected() && calculus.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if ((event.getStateChange() == ItemEvent.DESELECTED) && (data.isSelected() || calculus.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		});
		
		data.addItemListener(new ItemListener() {
		
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					none.setSelected(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (functions.isSelected() && calculus.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (functions.isSelected() || calculus.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		});
		
		calculus.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent event) {
				
				if (event.getStateChange() == ItemEvent.SELECTED) {
					
					confirm.setEnabled(true);
					none.setSelected(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED) {
					
					confirm.setEnabled(false);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (functions.isSelected() && data.isSelected())) {
					
					confirm.setEnabled(true);
				}
				
				if (event.getStateChange() == ItemEvent.DESELECTED && (functions.isSelected() || data.isSelected())) {
					
					confirm.setEnabled(true);
				}
			}
			
		}); 
		
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				//intialize printWriter and write to it
				PrintWriter writer = null;

				String filename = "Storage.txt";

				try {
					writer = new PrintWriter(new FileWriter(filename, true));

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (functions.isSelected()) {
					
					mathCount++;
					last = last + "Advanced_Functions ";
				}
				
				if (data.isSelected()) {
					mathCount++;
					last = last + "Data_Management ";
				}
				
				if (calculus.isSelected()) {
					mathCount++;
					last = last + "Calculus ";
				}	
				
				if (none.isSelected()) {
					mathCount++;
					last = last + "None ";
				}
			
				//close file and open next window when continue button is clicked
				writer.write(mathCount + " " + last);
				writer.close();

				try {
					new PostSecondary();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}